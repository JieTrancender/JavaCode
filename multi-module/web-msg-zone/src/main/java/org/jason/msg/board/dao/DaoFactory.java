package org.jason.msg.board.dao;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by JTrancender on 2017/3/12.
 */
public class DaoFactory {
    private static Properties properties = null;

    static {
//        加载配置文件内容到properties对象中
        try {
            InputStream inputStream = DaoFactory.class.getResourceAsStream("/dao.properties");
            properties = new Properties();
            properties.load(inputStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static MessageDao getMessageDao() {
        String daoClassName = properties.getProperty("MessageDao");
        System.out.println("properties:" + properties);
        System.out.println("daoClassName:" + daoClassName);

        try {
            Class clazz = Class.forName(daoClassName);
            System.out.println("clazz:" + clazz);
            return (MessageDao) clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
