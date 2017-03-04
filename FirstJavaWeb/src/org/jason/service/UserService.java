package org.jason.service;

import org.jason.dao.UserDao;
import org.jason.domain.User;

/**
 * Created by JTrancender on 2017/3/4.
 */
public class UserService {
    /**
     * service层依赖Dao层
     */
    private UserDao userDao = new UserDao();

    /**
     * service的查询，需要使用dao来完成
     * @return
     */
    public User find() {
        return userDao.find();
    }
}
