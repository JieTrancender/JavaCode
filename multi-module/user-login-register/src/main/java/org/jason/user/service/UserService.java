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

    public void createUser(User user) throws UserException {
        User tempUser = userDao.read(user.getIdentityType(), user.getIdentifier());
        UserException.require(null == tempUser, user.getIdentityType() + "(" + user.getIdentifier() + ")已经被注册!");
        userDao.create(user);
    }

    public User readUserAuth(UserAuth userAuth) throws UserException {
        UserAuth userAuthTemp = userAuthDao.read(userAuth.getIdentityType(), userAuth.getIdentifier());
        UserException.require(null != userAuthTemp, userAuth.getIdentityType() + "(" + userAuth.getIdentifier() + ")未注册!");
        UserException.require(userAuth.getCredentialDigest().equals(userAuthTemp.getCredentialDigest()),
                userAuth.getIdentityType() + "(" + userAuth.getIdentifier() + ")用户名或密码错误!");
        return userDao.read(userAuthTemp.getIdentityType(), userAuthTemp.getIdentifier());
    }

    public User readUserAuth(String userIdDigest, String rememberMeDigest) throws UserException {
        UserAuth userAuth = userAuthDao.readByRememberMe(userIdDigest, rememberMeDigest);
        UserException.require(null != userAuth, userIdDigest + "&" + rememberMeDigest + "已失效!");
        return userDao.read(userAuth.getIdentityType(), userAuth.getIdentifier());
    }

    public void updateUserAuth(UserAuth userAuth, String rememberMeDigest) throws UserException {
        readUserAuth(userAuth);
        userAuthDao.updateRememberMe(userAuth.getIdentityType(), userAuth.getIdentifier(), rememberMeDigest);
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

    public User read(String identityType, String identifier) {
        return userDao.read(identityType, identifier);
    }
}
