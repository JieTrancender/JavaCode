import org.apache.commons.dbutils.QueryRunner;
import org.jason.common.TxQueryRunner;
import org.jason.dao.JdbcUserAuthDaoImpl;
import org.jason.dao.JdbcUserDaoImpl;
import org.jason.domain.User;
import org.jason.domain.UserAuth;
import org.junit.Test;

/**
 * Created by JTrancender on 2017/4/12.
 */
public class JdbcDaoImplTest {
    @Test
    public void testUserDaoAdd() {
        JdbcUserDaoImpl userDao = new JdbcUserDaoImpl();
        User user = new User("Jason", "男", "default.jpg", "email", "582865471-1@qq.com", "ShaoJie@qq.com");
        userDao.addUser(user);
    }

    @Test
    public void testUserDaoFindUser() {
        JdbcUserDaoImpl userDao = new JdbcUserDaoImpl();
        User user = userDao.findUser("email", "582865471@qq.com");
        if (user != null) {
            System.out.println(user.toString());
        } else {
            System.out.println("null");
        }
    }

    @Test
    public void testUserAuthDaoFindUserAuth() {
        JdbcUserAuthDaoImpl userAuthDao = new JdbcUserAuthDaoImpl();
        UserAuth userAuth = userAuthDao.find("email", "582865471@qq.com");
        if (userAuth != null) {
            System.out.println(userAuth.toString());
        } else {
            System.out.println("null");
        }
    }

    @Test
    public void testRememberLogin() {
        JdbcUserAuthDaoImpl userAuthDao = new JdbcUserAuthDaoImpl();
        UserAuth userAuth = new UserAuth();
        userAuth.setIdentityType("email");
        userAuth.setIdentifier("582865471@qq.com");
        userAuthDao.rememberLogin(userAuth);
    }

    @Test
    public void testFindByRememberMe() {
        String userIdDigest = "23C378F087254C03A17C85D7D4CDF665";
        String rememberMeDigest = "734rjK97vErmbGEjoMT/vA==";
        JdbcUserAuthDaoImpl userAuthDao = new JdbcUserAuthDaoImpl();
        UserAuth userAuth = userAuthDao.findByRememberMe(userIdDigest, rememberMeDigest);
        System.out.println(userAuth);
    }
}
