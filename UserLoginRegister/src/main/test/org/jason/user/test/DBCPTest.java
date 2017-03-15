package org.jason.user.test;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by JTrancender on 2017/3/15.
 */
public class DBCPTest {
    @Test
    public void testSqlPool() throws SQLException {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/javadb");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

//        dataSource.setMaxActive(20);
        dataSource.setMinIdle(3);
        dataSource.setMaxWaitMillis(1000);

        Connection conn = dataSource.getConnection();
        System.out.println(conn.getClass().getName());

        /**
         * 连接池内部使用四大参数创建了连接对象，即mysql驱动提供的Connection
         * 连接池使用mysql的连接对象进行了装饰，支队close方法进行增强
         * 装饰之后的close的方法用来把唐倩连接归还给池
         */
        conn.close();//把连接归还给连接池
    }
}
