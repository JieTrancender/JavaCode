import jason.common.tools.CommonUtils;
import jason.user.dao.JdbcUserDaoImpl;
import jason.user.dao.UserDao;
import jason.user.domain.User;
import jason.user.domain.UserAuth;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

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
        String identityType = "email";
        String identifier = "jie-email@jie-trancender.org";
        User user = userDao.read(identityType, identifier);
        System.out.println(user);
    }

    @Test
    public void testUserDao() {
        User user = new User("test", "test", "test", "test", "test", "test");
        System.out.println(user.toString());
    }

    @Test
    public void testReadUsers() {
        UserDao userDao = new JdbcUserDaoImpl();
        ArrayList<User> users = userDao.read("");
        Iterator<User> iter = users.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
