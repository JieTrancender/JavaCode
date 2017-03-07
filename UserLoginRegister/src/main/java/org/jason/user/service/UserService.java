package org.jason.user.service;

import org.jason.user.dao.UserDao;
import org.jason.user.domain.User;

/**
 * User业务层
 * Created by JTrancender on 2017/3/7.
 */
public class UserService {
    private UserDao userDao = new UserDao();

    public void register(User user) throws UserException {
        User _user = userDao.findByUserName(user.getUserName());

        if (null != _user) {
            throw new UserException("用户名\"" + user.getUserName() + "\"已经被注册过了！");
        }

        userDao.add(user);
    }
}
