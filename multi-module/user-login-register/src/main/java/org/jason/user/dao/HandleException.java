package org.jason.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by JTrancender on 2017/4/12.
 */
public class HandleException {
    public static void handleException(Connection conn, PreparedStatement pstmt) {
        try {
            if (conn != null) {
                conn.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (Exception e) {}  //no content
    }
}
