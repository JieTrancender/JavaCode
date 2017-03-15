package org.jason.account;

import org.jason.commons.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by JTrancender on 2017/3/15.
 */
public class Account {
    public void transfer(String from, String to, double money) {
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false);

            AccountDao accountDao = new AccountDao();
            accountDao.updateBalance(conn, from, -money);
            accountDao.updateBalance(conn, to, money);

            conn.commit();
            conn.close();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
            }
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testTransfer() {
        transfer("zs", "ls", 1000);
    }
}
