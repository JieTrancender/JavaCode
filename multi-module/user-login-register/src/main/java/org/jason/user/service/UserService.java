package org.jason.user.service;

import org.jason.commons.CommonUtils;
import org.jason.user.dao.JdbcUserAuthDaoImpl;
import org.jason.user.dao.JdbcUserDaoImpl;
import org.jason.user.dao.UserAuthDao;
import org.jason.user.dao.UserDao;
import org.jason.user.domain.User;
import org.jason.user.domain.UserAuth;


/**
 * Created by JTrancender on 2017/4/12.
 */
public class UserService {
    private UserDao userDao = new JdbcUserDaoImpl();
    private UserAuthDao userAuthDao = new JdbcUserAuthDaoImpl();

    public void register(User user) throws UserException {
        User _user = userDao.read(user.getUserAuth().getIdentityType(), user.getUserAuth().getIdentifier());
        if (null != _user) {
            throw new UserException(user.getUserAuth().getIdentityType() + ":" + user.getUserAuth().getIdentifier() + " 已经被注册！");
        }
        userDao.create(user);
    }

    public void login(UserAuth user) throws UserException {
        User _user = userDao.read(user.getIdentityType(), user.getIdentifier());
        if (null == _user) {
            throw new UserException(user.getIdentityType() + ":" + user.getIdentifier() + " 用户不存在！");
        }

        if (!_user.getUserAuth().getCredentialDigest().equals(user.getCredentialDigest())) {
            throw new UserException(user.getIdentityType() + "或者密码输入错误！");
        }
    }

    public User cookieLogin(String userIdDigest, String rememberMeDigest) throws UserException {
        UserAuth _userAuth = userAuthDao.readByRememberMe(userIdDigest, rememberMeDigest);
        if (_userAuth == null) {
            throw new UserException(userIdDigest + ":" + rememberMeDigest + "已失效!");
        }
        return userDao.read(_userAuth.getIdentityType(), _userAuth.getIdentifier());
    }

    public void rememberLogin(UserAuth userAuth) {
        userAuthDao.updateRememberMe(userAuth.getIdentityType(), userAuth.getIdentifier(), CommonUtils.getRememberMeDigest());
    }

    public void forgetLogin(UserAuth userAuth) {
        userAuthDao.updateRememberMe(userAuth.getIdentityType(), userAuth.getIdentifier(), CommonUtils.getRememberMeDigest());
    }

    public User find(UserAuth userAuth) {
        return userDao.read(userAuth.getIdentityType(), userAuth.getIdentifier());
    }
}
