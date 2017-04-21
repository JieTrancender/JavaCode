package org.jason.user.test;

import org.jason.account.AccountDao;
import org.jason.commons.JdbcUtils;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Created by JTrancender on 2017/3/15.
 */
public class JdbcUtilsTest {
    private AccountDao accountDao = new AccountDao();

    @Test
    public void serviceMethod() {
        try {
            JdbcUtils.beginTransaction();
            accountDao.updateBalance("zs", -100);
            accountDao.updateBalance("ls", 100);
            JdbcUtils.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                JdbcUtils.rollbackTransaction();
            } catch (SQLException e1) {
            }
        }
    }
}
