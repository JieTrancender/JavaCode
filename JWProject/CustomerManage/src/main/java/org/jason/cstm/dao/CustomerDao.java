package org.jason.cstm.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.jason.commons.TxQueryRunner;

/**
 * 持久层
 * Created by JTrancender on 2017/3/16.
 */
public class CustomerDao {
    private QueryRunner queryRunner = new TxQueryRunner();
}
