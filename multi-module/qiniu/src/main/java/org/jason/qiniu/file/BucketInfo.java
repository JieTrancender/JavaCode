package org.jason.qiniu.file;

import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.util.Auth;

/**
 * Created by JTrancender on 2017/5/16.
 */
public class BucketInfo {
    private Configuration configuration = new Configuration(Zone.autoZone());
    private String accessKey = "3Qtork7ifbgTZ9tWPuNGULubJN0KOXbRwHZ33Txr";
    private String secretKey = "TG5dfKXaXy-3uKYEEsW51x8SYLJ9H-5A8lWOxs7I";
    private String bucket = "jie-trancender";
    private Auth auth = Auth.create(accessKey, secretKey);
    BucketManager bucketManager = new BucketManager(auth, configuration);
    String prefix = "";
    int limit = 1000;
    String delimiter = "photos/MingEr";


}
