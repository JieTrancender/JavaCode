package org.jason.user.dao;

import com.mysql.jdbc.PreparedStatement;
import org.jason.commons.OldJdbcUtils;
import org.jason.user.domain.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by JTrancender on 2017/3/12.
 */
public class JdbcUserDaoImpl implements UserDao {
    public void add(User user) {
        /**
         * 1. 得到链接
         * 2. 准备sql模板，得到pstmt
         * 3. 为PrepareStatement对象赋值
         * 4. 执行executeUpdate函数
         */
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = OldJdbcUtils.getConnection();

            String sql = "insert into user values(?,?,?,?)";
            pstmt = (PreparedStatement) conn.prepareStatement(sql);

            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getPassword());
            pstmt.setInt(3, user.getAge());
            pstmt.setString(4, user.getGender());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {}
        }
    }

    public User findByUserName(String userName) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        try {
            conn = OldJdbcUtils.getConnection();

            String sql = "select * from user where username=?";
            pstmt = (PreparedStatement) conn.prepareStatement(sql);

            pstmt.setString(1, userName);

//            获取User对象
            resultSet = pstmt.executeQuery();

            if (resultSet == null) {
                return null;
            }
            if (resultSet.next()) {
                //转换User对象，并返回
                //ORM --> 对象关系映射
                User user = new User();
                user.setUserName(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setAge(resultSet.getInt("age"));
                user.setGender(resultSet.getString("gender"));

                return user;
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {}
        }
    }
}
