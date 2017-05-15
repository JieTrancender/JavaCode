package org.jason.common;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by JTrancender on 2017/4/12.
 */
public class JdbcUtils {
    //使用配置文件中的默认配置，必须存在c3p0-config.xml
    private static ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("mysql-config");
    //事务专用连接
    private static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<Connection>();

    public static Connection getConnection() throws SQLException {
        Connection conn = connectionThreadLocal.get();
        if (conn != null) {
            return conn;
        }
        return comboPooledDataSource.getConnection();
    }

    public static DataSource getDataSource() {
        return comboPooledDataSource;
    }

    /**
     * 开启事务
     *   1. 获取一个Connection，setAutoCommit(false)
     *   2. 保证Dao中使用的连接是我们刚刚创建的
     */
    public static void beginTransaction() throws SQLException {
        Connection conn = connectionThreadLocal.get();
        if (conn != null) {
            throw new SQLException("已经开启事务，请不要重复开启事务!");
        }

        conn = getConnection();
        conn.setAutoCommit(false);
        connectionThreadLocal.set(conn);
    }

    /**
     * 提交事务
     *   获取beginTransaction提供的Connection
     */
    public static void commitTransaction() throws SQLException {
        Connection conn = connectionThreadLocal.get();
        if (conn == null) {
            throw new SQLException("没有开启事务，不能提交！");
        }
        conn.commit();
        conn.close();
        connectionThreadLocal.remove();  //移除
    }

    public static void rollbackTransaction() throws SQLException {
        Connection conn = connectionThreadLocal.get();
        if (conn == null) {
            throw new SQLException("没有开启事务，不能回滚!");
        }
        conn.rollback();
        conn.close();
        connectionThreadLocal.remove();
    }

    /**
     * 释放连接
     *   如果是事务专用，就不关闭
     *   如果不是事务专用，就关闭
     */
    public static void releaseConnection(Connection connection) throws SQLException {
        Connection conn = connectionThreadLocal.get();

        if (conn == null || conn != connection) {
            connection.close();
        }
    }
}
