package org.jason.user.dao;

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

    public static UserDao getUserDao() {
        //从配置文件中得到dao实现类的名称
        String daoClassName = properties.getProperty("org.jason.user.dao.UserDao");

        //通过反射来创建实现类的对象
        try {
            Class clazz = Class.forName(daoClassName);
            return (UserDao) clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
