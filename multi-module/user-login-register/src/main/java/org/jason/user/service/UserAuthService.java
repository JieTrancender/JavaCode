package org.jason.user.service;

import org.jason.user.dao.JdbcUserAuthDaoImpl;
import org.jason.user.dao.UserAuthDao;

/**
 * Created by JTrancender on 2017/4/12.
 */
public class UserAuthService {
    private UserAuthDao userAuthDao = new JdbcUserAuthDaoImpl();
}
