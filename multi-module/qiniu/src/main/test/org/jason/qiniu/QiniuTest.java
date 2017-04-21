package org.jason.qiniu;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.storage.persistent.FileRecorder;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.nio.file.Paths;

/**
 * Created by JTrancender on 2017/4/18.
 */
public class QiniuTest {
    private static Auth getAuth() {
        String accessKey = "3Qtork7ifbgTZ9tWPuNGULubJN0KOXbRwHZ33Txr";
        String secretKey = "TG5dfKXaXy-3uKYEEsW51x8SYLJ9H-5A8lWOxs7I";

        return Auth.create(accessKey, secretKey);
    }

    private static String getUpToken() {
        return getAuth().uploadToken(bucket);
    }

    private static void printResponse(Response response) {
        try {
            DefaultPutRet defaultPutRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(defaultPutRet.key);
            System.out.println(defaultPutRet.hash);
        } catch (QiniuException e) {
            Response r = e.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex) {
                //ignore
            }
        }
    }

    private static String bucket = "sources";
    private static long expireSeconds = 3600;
    private static Configuration configuration = new Configuration(Zone.autoZone());
    private static UploadManager uploadManager = new UploadManager(configuration);

    @Test
    public void testUpload1() {
        String upToken = getAuth().uploadToken(bucket);
        System.out.println(upToken);
    }

    @Test
    public void testUpload2() {
        String key = "file key";
        Auth auth = getAuth();

        String upToken = auth.uploadToken(bucket, key);
        System.out.println(upToken);
    }

    @Test
    public void testUpload3() {
        Auth auth = getAuth();
        StringMap putPolicy = new StringMap();

        putPolicy.put("returnBody", "{\"key\":\"$(key)\", \"hash\":\"$(etag)\", \"bucket\":\"$(bucket)\", \"fsize\":\"$(fsize)}");
//        long expireSeconds = 3600;
        String upToken = auth.uploadToken(bucket, null, expireSeconds, putPolicy);
        System.out.println(upToken);
    }

    @Test
    public void testUpload4() {
        Auth auth = getAuth();
        StringMap putPolicy = new StringMap();

        putPolicy.put("callbackUrl", "http://jie-trancender.org:8080/qiniu/upload/callback");
        //putPolicy.put("callbackUrl", "http://jie-trancender.org:8080/qiniu/upload/callback");
        putPolicy.put("callbackBody", "{\"key\":\"$(key)\", \"hash\":\"$(etag)\", \"bucket\":\"$(bucket)\", \"fsize\":\"$(fsize)}");
        putPolicy.put("callbackBodyType", "application/json");
//        long expireSeconds = 3600;
        String upToken = auth.uploadToken(bucket, null, expireSeconds, putPolicy);
        System.out.println(upToken);
    }

    @Test
    public void testUpload5() {
        Auth auth = getAuth();
        StringMap putPolicy = new StringMap();

        putPolicy.put("callbackUrl", "http://jie-trancender.org:8080/qiniu/upload/callback");
        putPolicy.put("callbackBody", "key=$(key)&hash=$(etag)&bucket=$(bucket)&fsize=$(fsize)");
        String upToken = auth.uploadToken(bucket, null, expireSeconds, putPolicy);
        System.out.println(upToken);
    }

    //文件上传
    @Test
    public void testServerUpload1() {
        Configuration configuration = new Configuration(Zone.autoZone());
        UploadManager uploadManager = new UploadManager(configuration);

        String localFilePath = "F:\\qshell-bucket\\logo.jpg";
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = "images/java-qiniu/my-logo.jpg";
        Auth auth = getAuth();
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(localFilePath, key, upToken);
            //解析上传结果
            DefaultPutRet defaultPutRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(defaultPutRet.key);
            System.out.println(defaultPutRet.hash);
        } catch (QiniuException e) {
            Response response = e.response;
            System.err.println(response.toString());
            try {
                System.err.println(response.bodyString());
            } catch (QiniuException ex) {
                //ignore
            }
        }
    }

    //字节数组上传
    @Test
    public void testServerUpload2() {
        String key = null;
        try {
            byte[] uploadBytes = "hello qiniu cloud".getBytes("utf-8");
            Auth auth = getAuth();
            String upToken = auth.uploadToken(bucket);
            printResponse(uploadManager.put(uploadBytes, key, upToken));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //数据流上传
    @Test
    public void testServerUpload3() {
        String key = null;
        try {
            byte[] uploadBytes = "hello qiniu cloud".getBytes("utf-8");
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(uploadBytes);
            printResponse(uploadManager.put(byteArrayInputStream, key, getUpToken(), null, null));;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //断点续上传
    @Test
    public void testServerUpload4() {
        String key = "music/java-qiniu-if-you.mp3";
        String localFilePath = "F:\\qshell-bucket\\if you.mp3";
        String localTempDir = Paths.get(System.getenv("java.io.tmpdir"), bucket).toString();
        try {
            FileRecorder fileRecorder = new FileRecorder(localTempDir);
            UploadManager uploadManager = new UploadManager(configuration, fileRecorder);
            printResponse(uploadManager.put(localFilePath, key, getUpToken()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
