package org.jason.account;

import org.jason.commons.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by JTrancender on 2017/3/15.
 */
public class AccountDao {
    public void updateBalance(Connection conn, String name, double balance) {
//        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
//            conn = JdbcUtils.getConnection();
            String sql = "update account set balance=balance+? where name=?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setDouble(1, balance);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
//                if (conn != null) conn.close();
            } catch (Exception e) {}
        }
    }
}
