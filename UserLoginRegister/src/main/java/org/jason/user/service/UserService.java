package org.jason.user.service;

import org.jason.user.dao.DaoFactory;
import org.jason.user.dao.UserDao;
import org.jason.user.domain.User;

/**
 * User业务层
 * Created by JTrancender on 2017/3/7.
 */
public class UserService {
    //把具体的实现类的创建，隐藏到工厂中
    private UserDao userDao = DaoFactory.getUserDao();

    public void register(User user) throws UserException {
        User _user = userDao.findByUserName(user.getUserName());

        if (null != _user) {
            throw new UserException("用户名\"" + user.getUserName() + "\"已经被注册过了！");
        }

        userDao.add(user);
    }

    public void login(User user) throws UserException {
        User _user = userDao.findByUserName(user.getUserName());

        if (null == _user) {
            throw new UserException("此用户不存在！");
        }

        if (!_user.getPassword().equals(user.getPassword())) {
            throw new UserException("用户名或密码输入错误！");
        }
    }

    public void checkVerifyCode(User user, String paramCode) throws UserException {
        if (!paramCode.equalsIgnoreCase(user.getVerifyCode())) {
            throw new UserException("验证码输入错误");
        }
    }
}
