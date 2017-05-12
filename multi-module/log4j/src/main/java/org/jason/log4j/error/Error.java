package org.jason.log4j.error;

import org.apache.log4j.Logger;

/**
 * Created by JTrancender on 2017/5/12.
 */
public class Error {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf("Debug"));
    public static void main(String[] args) {
        LOGGER.error("debug in debug level");
    }
}
