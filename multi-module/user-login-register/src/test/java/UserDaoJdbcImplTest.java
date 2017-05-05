import org.jason.commons.CommonUtils;
import org.jason.user.dao.JdbcUserDaoImpl;
import org.jason.user.dao.UserDao;
import org.jason.user.domain.User;
import org.jason.user.domain.UserAuth;
import org.junit.Test;

/**
 * Created by JTrancender on 2017/4/24.
 */
public class UserDaoJdbcImplTest {
    @Test
    public void testRegister() {
        String user_name = "MingEr";
        String user_gender = "女";
        String user_avatar = "images/avatar/default.jpg";
        String identity_type = "email";
        String identifier = "ming-email@jie-trancender.org";
        String credential = "ShaoJie@qq.com";
        String remember_me_digest = CommonUtils.uuid();
        String uuid = CommonUtils.uuid();
        User user = new User(user_name, user_gender, user_avatar, new UserAuth(uuid, identity_type, identifier, credential, CommonUtils.encoderByMd5(remember_me_digest)));

        UserDao userDao = new JdbcUserDaoImpl();
        userDao.add(user);
    }

    @Test
    public void testFind() {
        String identity_type = "email";
        String identifier = "jie-email@jie-trancender.org";
        UserDao userDao = new JdbcUserDaoImpl();
        User user = userDao.find(identity_type, identifier);
        System.out.println(user.toString());
    }

    @Test
    public void testUserDao() {
        User user = new User("test", "test", "test", "test", "test", "test");
        System.out.println(user.toString());
    }
}
