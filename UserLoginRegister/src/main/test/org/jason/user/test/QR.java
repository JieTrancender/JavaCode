package org.jason.user.test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by JTrancender on 2017/3/15.
 */
public class QR<T> {
    private DataSource dataSource;


    public QR() {
    }

    public QR(DataSource dataSource) {

        this.dataSource = dataSource;
    }

    public int update(String sql, Object... params) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(sql);
            initParams(pstmt, params);

            return pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {}
        }
    }

    //给参数赋值
    private void initParams(PreparedStatement pstmt, Object... params) throws SQLException {
        for (int i = 0; i < params.length; ++i) {
            pstmt.setObject(i + 1, params[i]);
        }
    }


    public T query(String sql, RsHandler<T> rsHandler, Object... params) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(sql);
            initParams(pstmt, params);

            resultSet = pstmt.executeQuery();
            return rsHandler.handle(resultSet);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {}
        }
    }
}

//把结果集转换成对象,谁调用 谁实现
interface RsHandler<T> {
    public T handle(ResultSet rs) throws SQLException;
}
