package org.jason.user.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by JTrancender on 2017/3/15.
 */
public class C3P0 {
    @Test
    public void testC3P0() throws PropertyVetoException, SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

        comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/javadb?useSSL=false");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("123456");

        comboPooledDataSource.setAcquireIncrement(5);
        comboPooledDataSource.setInitialPoolSize(20);
        comboPooledDataSource.setMinPoolSize(2);
        comboPooledDataSource.setMaxPoolSize(50);

        Connection conn = comboPooledDataSource.getConnection();
        System.out.println(conn);
        conn.close();
    }

    @Test
    public void testFunc() throws SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

        Connection conn = comboPooledDataSource.getConnection();
        System.out.println(conn);
        conn.close();
    }

    @Test
    public void testMysql() throws SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("mysql-config");

        Connection conn = comboPooledDataSource.getConnection();
        System.out.println(conn);
        conn.close();
    }
}
