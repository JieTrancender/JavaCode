import org.jason.commons.CommonUtils;
import org.jason.user.dao.JdbcUserAuthDaoImpl;
import org.jason.user.dao.JdbcUserDaoImpl;
import org.jason.user.dao.UserAuthDao;
import org.jason.user.dao.UserDao;
import org.jason.user.domain.User;
import org.jason.user.domain.UserAuth;
import org.junit.Test;

/**
 * Created by JTrancender on 2017/4/12.
 */
public class JdbcDaoImplTest {
    @Test
    public void testUserDaoAdd() {
        UserDao userDao = new JdbcUserDaoImpl();
        //User user = new User("Jason", "男", "default.jpg" );
        //userDao.add(user);
    }

    @Test
    public void testUserDaoFind() {
        int user_id = 1;
        UserDao userDao = new JdbcUserDaoImpl();
//        User user = userDao.findByUserUserId(user_id);
//        System.out.println(user.toString());
    }

    @Test
    public void testUserAuthDaoAdd() {
        UserAuthDao userAuthDao = new JdbcUserAuthDaoImpl();
        String remember_me_digest = CommonUtils.encoderByMd5(CommonUtils.uuid());
        UserAuth userAuth = new UserAuth("1", "userName", "MingEr", "123456", remember_me_digest);
        userAuthDao.add(userAuth);
    }

    @Test
    public void testUserAuthDaoFind() {
        UserAuthDao userAuthDao = new JdbcUserAuthDaoImpl();
        UserAuth userAuth = userAuthDao.findByTypeAndIdentifier("userName", "MingEr");
        System.out.println(userAuth);

//        User user = new JdbcUserDaoImpl().findByUserUserId(userAuth.getUserId());
//        System.out.println(user);
    }
}
