package org.jason.log4j.info;

import org.apache.log4j.Logger;

/**
 * Created by JTrancender on 2017/5/12.
 */
public class Info {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf("Debug"));
    public static void main(String[] args) {
        LOGGER.info("debug in debug level");
    }
}
