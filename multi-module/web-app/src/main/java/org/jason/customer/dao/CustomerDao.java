package org.jason.customer.dao;

import org.jason.customer.domain.Customer;

import java.util.ArrayList;

/**
 * Created by JTrancender on 2017/5/26.
 */
public interface CustomerDao {
    void create(Customer customer);
    void update(Customer customer);
    Customer read(String ip);
    int[] readPageView();
    int readSumCount();
    ArrayList<Customer> index();
}
