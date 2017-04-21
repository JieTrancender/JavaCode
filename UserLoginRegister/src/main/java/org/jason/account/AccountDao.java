package org.jason.account;

import org.apache.commons.dbutils.QueryRunner;
import org.jason.commons.TxQueryRunner;

import java.sql.SQLException;

/**
 * Created by JTrancender on 2017/3/15.
 */
public class AccountDao {
    public void updateBalance(String name, double balance) throws SQLException {
        QueryRunner queryRunner = new TxQueryRunner();
        String sql = "update account set balance=balance+? where name=?";
        Object[] params = {balance, name};

        queryRunner.update(sql, params);
    }
}
