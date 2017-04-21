package org.jason.user.service;

import org.jason.user.dao.JdbcUserDaoImpl;
import org.jason.user.dao.UserDao;
import org.jason.user.domain.User;

/**
 * Created by JTrancender on 2017/4/12.
 */
public class UserService {
    private UserDao userDao = new JdbcUserDaoImpl();

    public void register(User user) throws UserException {
        User _user = userDao.find(user.getUserAuth().getIdentityType(), user.getUserAuth().getIdentifier());
        if (null != _user) {
            throw new UserException(user.getUserAuth().getIdentityType() + ":" + user.getUserAuth().getIdentifier() + "已经被注册！");
        }
        userDao.add(user);
    }
}
