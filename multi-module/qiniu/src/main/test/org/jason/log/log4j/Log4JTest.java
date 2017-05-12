package org.jason.log.log4j;

import org.apache.log4j.Logger;

/**
 * Created by JTrancender on 2017/5/12.
 *
 */ public class Log4JTest {
     private static final Logger LOGGER = Logger.getLogger(String.valueOf(Log4JTest.class));
     public static void main(String[] args) {
         LOGGER.debug("This is debug message.");
         LOGGER.info("This is info message.");
         LOGGER.info("This is warn message.");
         LOGGER.error("This is error message.");
     }
}
