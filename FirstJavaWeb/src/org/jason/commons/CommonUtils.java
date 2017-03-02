package org.jason.commons;

import java.util.UUID;

/**
 * Created by JTrancender on 2017/3/2.
 */
public class CommonUtils {
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }
}
