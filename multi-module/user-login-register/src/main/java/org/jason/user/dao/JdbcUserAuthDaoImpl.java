package org.jason.user.dao;

import org.jason.commons.CommonUtils;
import org.jason.commons.JdbcUtils;
import org.jason.user.domain.UserAuth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by JTrancender on 2017/4/12.
 */
public class JdbcUserAuthDaoImpl implements UserAuthDao {
    public void add(UserAuth userAuth) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into user_auths(user_id, identity_type, identifier, credential_digest, remember_me_digest) values(?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, userAuth.getUserId());
            pstmt.setString(2, userAuth.getIdentityType());
            pstmt.setString(3, userAuth.getIdentifier());
            pstmt.setString(4, userAuth.getCredentialDigest());
            pstmt.setString(5, userAuth.getRememberMeDigest());

            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            HandleException.handleException(conn, pstmt);
        }
    }

    public UserAuth findByTypeAndIdentifier(String identity_type, String identifier) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        try {
            conn = JdbcUtils.getConnection();
            String sql = "select user_id, identity_type, identifier, credential_digest, remember_me_digest from user_auths where identity_type = ? and identifier = ?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, identity_type);
            pstmt.setString(2, identifier);

            resultSet = pstmt.executeQuery();
            if (resultSet == null) {
                return null;
            }
            if (resultSet.next()) {
                UserAuth userAuth = new UserAuth();
                userAuth.setUserId(resultSet.getString("user_id"));
                userAuth.setIdentityType(resultSet.getString("identity_type"));
                userAuth.setIdentifier(resultSet.getString("identifier"));
                userAuth.setCredential(resultSet.getString("credential_digest"));
                userAuth.setRememberMeDigest(resultSet.getString("remember_me_digest"));

                return userAuth;
            } else {
                return null;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            HandleException.handleException(conn, pstmt);
        }
    }

    public UserAuth findByUserIdAndRememberMe(String userIdDigest, String rememberMeDigest) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        try {
            conn = JdbcUtils.getConnection();
            String sql = "select user_id, identity_type, identifier, credential_digest, remember_me_digest from user_auths where user_id = ? and remember_me_digest = ?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, userIdDigest);
            pstmt.setString(2, rememberMeDigest);

            resultSet = pstmt.executeQuery();
            if (resultSet == null) {
                return null;
            }
            if (resultSet.next()) {
                UserAuth userAuth = new UserAuth();
                userAuth.setUserId(resultSet.getString("user_id"));
                userAuth.setIdentityType(resultSet.getString("identity_type"));
                userAuth.setIdentifier(resultSet.getString("identifier"));
                userAuth.setCredential(resultSet.getString("credential_digest"));
                userAuth.setRememberMeDigest(resultSet.getString("remember_me_digest"));

                return userAuth;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            HandleException.handleException(conn, pstmt);
        }
    }

    public void rememberLogin(UserAuth userAuth) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JdbcUtils.getConnection();
            String remember_me_digest = CommonUtils.getRememberMeDigest();
            String sql = "update user_auths set remember_me_digest = ? where identity_type = ? and identifier = ?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, remember_me_digest);
            pstmt.setString(2, userAuth.getIdentityType());
            pstmt.setString(3, userAuth.getIdentifier());

            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            HandleException.handleException(conn, pstmt);
        }
    }

    public void forgetLogin(UserAuth userAuth) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JdbcUtils.getConnection();
            String sql = "update user_auths set remember_me_digest = null where identity_type = ? and identifier = ?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, userAuth.getIdentityType());
            pstmt.setString(2, userAuth.getIdentifier());

            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            HandleException.handleException(conn, pstmt);
        }
    }
}
