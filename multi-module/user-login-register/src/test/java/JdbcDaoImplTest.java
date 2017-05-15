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
    private UserAuthDao userAuthDao = new JdbcUserAuthDaoImpl();

    @Test
    public void testUserAuthDaoCreate() {
        String remember_me_digest = CommonUtils.encoderByMd5(CommonUtils.uuid());
        UserAuth userAuth = new UserAuth("FCE309A2D2174EB8BF117F51A3E29C8D", "WeChat", "MingEr", "123456", remember_me_digest);
        userAuthDao.create(userAuth);
    }

    @Test
    public void testUserAuthDaoRead() {
        String identityType = "QQ";
        String identifier = "582865471";
        UserAuth userAuth = userAuthDao.read(identityType, identifier);
        System.out.println(userAuth);
    }

    @Test
    public void testUserAuthDaoReadByRememberMe() {
        String userIdDigest = "FCE309A2D2174EB8BF117F51A3E29C8D";
        String rememberMeDigest = "4l2BRvkCm73zUJNG4Ait+Q==";
        UserAuth userAuth = userAuthDao.readByRememberMe(userIdDigest, rememberMeDigest);
        System.out.println(userAuth);
    }

    @Test
    public void testUserAuthDaoUpdateRememberMe() {
        String rememberMeDigest = null;
        String identityType = "userName";
        String identifier = "MingEr";

        UserAuth userAuth = userAuthDao.read(identityType, identifier);
        System.out.println(userAuth);

        userAuthDao.updateRememberMe(identityType, identifier, rememberMeDigest);
        userAuth = userAuthDao.read(identityType, identifier);
        System.out.println(userAuth);
    }
}
