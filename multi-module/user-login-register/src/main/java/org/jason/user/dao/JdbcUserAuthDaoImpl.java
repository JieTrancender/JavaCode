package org.jason.user.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.jason.commons.TxQueryRunner;
import org.jason.user.domain.UserAuth;

import java.sql.SQLException;

/**
 * Created by JTrancender on 2017/4/12.
 */
public class JdbcUserAuthDaoImpl implements UserAuthDao {
    private QueryRunner queryRunner = new TxQueryRunner();

    public void create(UserAuth userAuth) {
        String sql = "insert into user_auths(userId, identityType, identifier, credentialDigest, rememberMeDigest) values(?, ?, ?, ?, ?)";
        Object[] params = {userAuth.getUserId(), userAuth.getIdentityType(), userAuth.getIdentifier(), userAuth.getCredentialDigest(), userAuth.getRememberMeDigest()};
        try {
            queryRunner.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public UserAuth read(String identityType, String identifier) {
        String sql = "select userId, identityType, identifier, credentialDigest, rememberMeDigest from user_auths where identityType = ? and identifier = ?";
        Object[] params = {identityType, identifier};
        UserAuth userAuth;
        try {
            userAuth = queryRunner.query(sql, new BeanHandler<UserAuth>(UserAuth.class), params);
            return userAuth;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public UserAuth readByRememberMe(String userIdDigest, String rememberMeDigest) {
        String sql = "select userId, identityType, identifier, credentialDigest, rememberMeDigest from user_auths where userId = ? and rememberMeDigest = ?";
        Object[] params = {userIdDigest, rememberMeDigest};
        UserAuth userAuth;
        try {
            userAuth = queryRunner.query(sql, new BeanHandler<UserAuth>(UserAuth.class), params);
            return userAuth;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateRememberMe(String identityType, String identifier, Object object) {
        String sql = "update user_auths set rememberMeDigest = ? where identityType = ? and identifier = ?";
        Object[] params = {object, identityType, identifier};
        try {
            queryRunner.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
