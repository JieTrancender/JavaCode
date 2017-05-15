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
    UserDao userDao = new JdbcUserDaoImpl();

    @Test
    public void testCreate() {
        String user_name = "MingEr";
        String user_gender = "女";
        String user_avatar = "images/avatar/default.jpg";
        String identity_type = "QQ";
        String identifier = "582865471";
        String credential = "ShaoJie@qq.com";
        String remember_me_digest = CommonUtils.getRememberMeDigest();
        String uuid = CommonUtils.uuid();
        User user = new User(user_name, user_gender, user_avatar, new UserAuth(uuid, identity_type, identifier, credential, remember_me_digest));
        userDao.create(user);
    }

    @Test
    public void testRead() {
        String identityType = "QQ";
        String identifier = "582865471";
        User user = userDao.read(identityType, identifier);
        System.out.println(user);
    }

    @Test
    public void testUserDao() {
        User user = new User("test", "test", "test", "test", "test", "test");
        System.out.println(user.toString());
    }
}
