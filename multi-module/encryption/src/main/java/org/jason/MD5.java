package org.jason;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by JTrancender on 2017/4/12.
 */
public class MD5 {
    public static String encoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder = new BASE64Encoder();

        return base64Encoder.encode(md5.digest(str.getBytes("utf-8")));
    }
}
