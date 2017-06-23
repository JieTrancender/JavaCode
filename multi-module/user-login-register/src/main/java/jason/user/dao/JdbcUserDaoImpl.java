package jason.user.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import jason.common.tools.JdbcUtils;
import jason.common.tools.TxQueryRunner;
import jason.user.domain.User;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by JTrancender on 2017/4/12.
 */
public class JdbcUserDaoImpl implements UserDao {
    private QueryRunner queryRunner = new TxQueryRunner();

    public void create(User user) {
        String userSql = "insert into users(userId, name, gender, avatar) values(?, ?, ?, ?)";
        Object[] userParams = {user.getUserId(), user.getName(), user.getGender(), user.getAvatar()};
        String userAuthSql = "insert into user_auths(userId, identityType, identifier, credentialDigest, rememberMeDigest) values(?, ?, ?, ?, ?)";
        Object[] userAuthParams = {user.getUserAuth().getUserId(),  user.getUserAuth().getIdentityType(), user.getUserAuth().getIdentifier(), user.getUserAuth().getCredentialDigest(),
            user.getUserAuth().getRememberMeDigest()};
        try {
            JdbcUtils.beginTransaction();
            queryRunner.update(userSql, userParams);
            queryRunner.update(userAuthSql, userAuthParams);
            JdbcUtils.commitTransaction();
        } catch (SQLException e) {
            try {
                JdbcUtils.rollbackTransaction();
            } catch (SQLException se) {
                throw new RuntimeException(se);
            }
            throw new RuntimeException(e);
        }
    }

    public User read(String identityType, String identifier) {
        String sql = "select u.userId, name, gender, avatar, identityType, identifier, credentialDigest, rememberMeDigest " +
                "from users u inner join user_auths a on u.userId = a.userId where identityType = ? and identifier = ?";
        Object[] params = {identityType, identifier};
        User user;
        try {
            user = queryRunner.query(sql, new BeanHandler<User>(User.class), params);
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<User> read(String userId) {
        String sql = "select u.userId, name, gender, avatar, identityType, identifier, credentialDigest, rememberMeDigest " +
                "from users u inner join user_auths a on u.userId = a.userId  and u.userId = ?";
        Object[] params = {userId};
        ArrayList<User> userArrayList = null;
        try {
            userArrayList = (ArrayList<User>) queryRunner.query(sql, new BeanListHandler<User>(User.class), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userArrayList;
    }

    public ArrayList<User> read() {
        String sql = "select u.userId, name, gender, avatar, identityType, identifier, credentialDigest, rememberMeDigest " +
                "from users u inner join user_auths a on u.userId = a.userId";
        Object[] params = {};
        ArrayList<User> userArrayList = null;
        try {
            userArrayList = (ArrayList<User>) queryRunner.query(sql, new BeanListHandler<User>(User.class), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userArrayList;
    }
}
