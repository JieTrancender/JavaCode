package org.jason.user.service;

import org.jason.user.dao.JdbcUserDaoImpl;
import org.jason.user.dao.UserDao;

/**
 * Created by JTrancender on 2017/4/12.
 */
public class UserService {
    private UserDao userDao = new JdbcUserDaoImpl();
}
