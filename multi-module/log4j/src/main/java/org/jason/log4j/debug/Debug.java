package org.jason.log4j.debug;

import org.apache.log4j.Logger;

/**
 * Created by JTrancender on 2017/5/12.
 */
public class Debug {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf("Debug"));
    public static void main(String[] args) {
        LOGGER.debug("debug in debug level");
        LOGGER.info("debug in debug level");
        LOGGER.error("debug in debug level");

    }
}
