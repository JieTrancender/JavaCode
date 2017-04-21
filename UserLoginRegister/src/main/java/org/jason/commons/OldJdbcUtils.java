package org.jason.commons;

import com.mysql.jdbc.Connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by JTrancender on 2017/3/12.
 */
public class OldJdbcUtils {
    private static Properties properties = null;

    //只在JdbcUtils类被加载时执行一次
    static {
        //给properties进行初始化，即加载dbconfig.properties文件到properties对象中
        try {
            InputStream inputStream = OldJdbcUtils.class.getResourceAsStream("/dbconfig.properties");
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //加载驱动类
        try {
            Class.forName(properties.getProperty("test.db.driverClassName"));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() throws SQLException {
        return (Connection) DriverManager.getConnection(properties.getProperty("test.db.url") + "?useSSL=false&rewriteBatchedStatements=true",
                properties.getProperty("test.db.userName"),
                properties.getProperty("test.db.password"));

//        Enumeration enumeration = properties.propertyNames();
//        while (enumeration.hasMoreElements()) {
//            String key = (String) enumeration.nextElement();
//            String value = properties.getProperty(key);
//            System.out.println(key + "=" + value);
//        }
//        String driverClassName = properties.getProperty("test.db.driverClassName");
//        String url = properties.getProperty("test.db.url") + "?useSSL=false";
//        String userName = properties.getProperty("test.db.userName");
//        String password = properties.getProperty("test.db.password");

//        Class.forName(driverClassName);
//        Connection connection = (Connection) DriverManager.getConnection(url, userName, password);
    }
}
