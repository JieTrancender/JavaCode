package org.jason.user.dao;

import org.apache.log4j.Logger;
import org.jason.commons.CommonUtils;
import org.jason.commons.JdbcUtils;
import org.jason.user.domain.User;
import org.jason.user.domain.UserAuth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.logging.Logger;

/**
 * Created by JTrancender on 2017/4/12.
 */
public class JdbcUserDaoImpl implements UserDao {
//    private static final Logger logger = Logger.getLogger(String.valueOf("JdbcUserDaoImpl"));
    public User find(String identity_type, String identifier) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        try {
            conn = JdbcUtils.getConnection();
            String sql = "select u.user_id, user_name, user_gender, user_avatar, identity_type, identifier, credential_digest, remember_me_digest " + 
                    "from users u inner join user_auths a on u.user_id = a.user_id where identity_type = ? and identifier = ?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, identity_type);
            pstmt.setString(2, identifier);

            resultSet = pstmt.executeQuery();

            if (resultSet == null) {
                return null;
            }
            if (resultSet.next()) {
                User user = new User();
                user.setName(resultSet.getString("user_name"));
                user.setGender(resultSet.getString("user_gender"));
                user.setAvatar(resultSet.getString("user_avatar"));
                UserAuth userAuth = new UserAuth();
                userAuth.setUserId(resultSet.getString("user_id"));
                userAuth.setIdentityType(resultSet.getString("identity_type"));
                userAuth.setIdentifier(resultSet.getString("identifier"));
                userAuth.setCredential(resultSet.getString("credential_digest"));
                userAuth.setRememberMeDigest(resultSet.getString("remember_me_digest"));
                user.setUserAuth(userAuth);
                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            HandleException.handleException(conn, pstmt);
        }
    }

    public void add(User user) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            JdbcUtils.beginTransaction();
            conn = JdbcUtils.getConnection();
            String sql = "insert into users(user_id, user_name, user_gender, user_avatar) values(?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, user.getUserAuth().getUserId());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getGender());
            pstmt.setString(4, user.getAvatar());

            pstmt.executeUpdate();

            sql = "insert into user_auths(user_id, identity_type, identifier, credential_digest, remember_me_digest) values(?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, user.getUserAuth().getUserId());
            pstmt.setString(2, user.getUserAuth().getIdentityType());
            pstmt.setString(3, user.getUserAuth().getIdentifier());
            pstmt.setString(4, user.getUserAuth().getCredentialDigest());
            pstmt.setString(5, user.getUserAuth().getRememberMeDigest());

            pstmt.executeUpdate();
            JdbcUtils.commitTransaction();
//            logger.info("JdbcUserDaoImpl#add:" + user.toString() + "success");
        } catch (Exception e) {
            try {
                JdbcUtils.rollbackTransaction();
//                logger.info("JdbcUserDaoImpl#add:" + user.toString() + " fail");
            } catch (SQLException se) {
                throw  new RuntimeException(se);
            }  //no content
            throw new RuntimeException(e);
        } finally {
            HandleException.handleException(conn, pstmt);
        }
    }
}
