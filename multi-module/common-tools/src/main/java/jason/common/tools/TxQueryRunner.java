package jason.common.tools;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 此类自己处理连接问题，无需外接传递
 * Created by JTrancender on 2017/3/15.
 */
public class TxQueryRunner extends QueryRunner {
    @Override
    public int[] batch(String sql, Object[][] params) throws SQLException {
        /**
         * 1. 得到连接
         * 2. 执行父类方法
         * 3. 释放连接
         * 4. 返回值
         */
        Connection conn = JdbcUtils.getConnection();
        int[] result = super.batch(conn, sql, params);
        JdbcUtils.releaseConnection(conn);
        return result;
    }

    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        T result = super.query(conn, sql, rsh, params);
        JdbcUtils.releaseConnection(conn);
        return result;
    }

    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        T result = super.query(conn, sql, rsh);
        JdbcUtils.releaseConnection(conn);
        return result;
    }

    @Override
    public int update(String sql) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        int result = super.update(conn, sql);
        JdbcUtils.releaseConnection(conn);
        return result;
    }

    @Override
    public int update(String sql, Object param) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        int result = super.update(conn, sql, param);
        JdbcUtils.releaseConnection(conn);
        return result;
    }

    @Override
    public int update(String sql, Object... params) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        int result = super.update(conn, sql, params);
        JdbcUtils.releaseConnection(conn);
        return result;
    }

    @Override
    public <T> T insert(String sql, ResultSetHandler<T> rsh) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        T result = super.insert(conn, sql, rsh);
        JdbcUtils.releaseConnection(conn);
        return result;
    }

    @Override
    public <T> T insert(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        T result = super.insert(sql, rsh, params);
        JdbcUtils.releaseConnection(conn);
        return result;
    }

    @Override
    public <T> T insertBatch(String sql, ResultSetHandler<T> rsh, Object[][] params) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        T result = super.insertBatch(sql, rsh, params);
        JdbcUtils.releaseConnection(conn);
        return result;
    }
}
