package org.jason.user.dao;

import org.jason.commons.JdbcUtils;
import org.jason.user.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by JTrancender on 2017/4/12.
 */
public class JdbcUserDaoImpl implements UserDao {
    public void add(User user) {
        /**
         * 1. 得到连接
         * 2. 准备sql模板，得到pstmt
         * 3. 位PrepareStatement对象赋值
         * 4. 执行executeUpdate函数
         */
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into users(user_name, user_gender, user_avatar) values(?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getGender());
            pstmt.setString(3, user.getAvatar());

            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            HandleException.handleException(conn, pstmt);
        }
    }

    public User findByUserUserId(int userId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        try {
            conn = JdbcUtils.getConnection();
            String sql = "select user_name, user_gender, user_avatar from users where user_id = ?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, userId);

            resultSet = pstmt.executeQuery();
            if (resultSet == null) {
                return null;
            }
            if (resultSet.next()) {
                User user = new User();
                user.setName(resultSet.getString("user_name"));
                user.setGender(resultSet.getString("user_gender"));
                user.setAvatar(resultSet.getString("user_avatar"));

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
}
