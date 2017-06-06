package org.jason.customer.dao;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.jason.commons.JdbcUtils;
import org.jason.commons.TxQueryRunner;
import org.jason.customer.domain.Customer;
import org.jason.user.dao.HandleException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by JTrancender on 2017/5/26.
 */
public class CustomerDaoJdbcImpl implements CustomerDao {
    private TxQueryRunner queryRunner = new TxQueryRunner();
    public void create(Customer customer) {
        String sql = "insert into customer(ip, times, created, updated) values(?, ?, ?, ?)";
        Object[] params = {customer.getIp(), customer.getTimes(), customer.getCreated(), customer.getUpdated()};
        try {
            queryRunner.update(sql, params);
        } catch (SQLException se) {
            throw new RuntimeException(se);
        }
    }

    public void update(Customer customer) {
        String sql = "update customer set times = ?, updated = ? where ip = ?";
        Object[] params = {customer.getTimes(), customer.getUpdated(), customer.getIp()};
        try {
            queryRunner.update(sql, params);
        } catch (SQLException se) {
            throw new RuntimeException(se);
        }
    }

    public Customer read(String ip) {
        String sql = "select ip, times, created, updated from customer where ip = ?";
        Customer customer;
        Object[] params = {ip};
        try {
            customer = queryRunner.query(sql, new BeanHandler<Customer>(Customer.class), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }

    public int[] readPageView() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        try {
            conn = JdbcUtils.getConnection();
            String sql = "select count(*) as first, sum(times) as second from customer";
            pstmt = conn.prepareStatement(sql);

            resultSet = pstmt.executeQuery();
            if (resultSet == null) {
                return null;
            }

            if (resultSet.next()) {
                int[] result = {resultSet.getInt("first"), resultSet.getInt("second")};
                return result;
            }
        } catch (SQLException se) {
            throw new RuntimeException(se);
        } finally {
            HandleException.handleException(conn, pstmt);
        }
        return new int[0];
    }

    public int readSumCount() {
        return 0;
    }

    public ArrayList<Customer> index() {
        return null;
    }
}
