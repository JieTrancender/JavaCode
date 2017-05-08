import org.jason.commons.CommonUtils;
import org.jason.user.dao.JdbcUserAuthDaoImpl;
import org.jason.user.dao.UserAuthDao;
import org.jason.user.domain.User;
import org.jason.user.domain.UserAuth;
import org.jason.user.service.UserException;
import org.jason.user.service.UserService;
import org.junit.Test;

/**
 * Created by JTrancender on 2017/4/24.
 */
public class UserServiceTest {
//    @Test
    public User testRegister() {
        UserAuth userAuth = new UserAuth(CommonUtils.uuid(), "phone", "18681700911", "JTrancender...", CommonUtils.encoderByMd5(CommonUtils.uuid()));
        User user = new User("JieTrancender", "男", "images/avatar/default.jpg", userAuth);
        UserService userService = new UserService();
        try {
            userService.register(user);
            System.out.println(user.getIdentityType() + ":" + user.getIdentifier() + " 注册成功！");
            return user;
        } catch (UserException ue) {
            System.err.println(ue.getMessage());
        }
        return user;
    }

    @Test
    public void testLogin() {
        UserAuth userAuth = new UserAuth();
        userAuth.setIdentityType("phone");
        userAuth.setIdentifier("18681700916");
        userAuth.setCredentialDigest("JTrancender...");

        UserService userService = new UserService();
        try {
            userService.login(userAuth);
            System.out.println(userAuth.getIdentityType() + ":" + userAuth.getIdentifier() + "登录成功！");
        } catch (UserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRemember() {
        UserService userService = new UserService();
        User user = testRegister();
        String identityType = user.getUserAuth().getIdentityType();
        String identifier = user.getUserAuth().getIdentifier();
        String credentialDigest = user.getUserAuth().getCredentialDigest();
        System.out.println(user.toString());
        System.out.println(user.getUserAuth().toString());

        userService.rememberLogin(user.getUserAuth());

        UserAuth userAuth = new UserAuth();
        userAuth.setIdentityType(identityType);
        userAuth.setIdentifier(identifier);
        System.out.println(userAuth.toString());
        User user1 = userService.find(userAuth);
        System.out.println(user1.getUserAuth().toString());
    }
    @Test
    public void testForget() {
        UserService userService = new UserService();
        User user = testRegister();
        System.out.println(user.getUserAuth().toString());
        userService.forgetLogin(user.getUserAuth());
        User user1 = userService.find(user.getUserAuth());
        System.out.println(user1.getUserAuth().toString());
        userService.rememberLogin(user1.getUserAuth());
        user1 = userService.find(user1.getUserAuth());
        System.out.println(user1.getUserAuth().toString());
    }

    @Test
    public void testFindByType() {
        String identity_type = "email";
        String identifier = "test@jie-trancender.org";
//        UserService userService = new UserService();
        UserAuthDao userAuthDao = new JdbcUserAuthDaoImpl();
        UserAuth userAuth = userAuthDao.findByTypeAndIdentifier(identity_type, identifier);
        System.out.println(userAuth.toString());
    }

    @Test
    public void testFindByCookie() {
        String userIdDigest = "9A93332EDDBE4375B6141D2870F03153";
        String rememberMeDigest = "eCmZ2W4S5N9H/JfjXSAQ+g==";
        UserAuthDao userAuthDao = new JdbcUserAuthDaoImpl();
        UserAuth userAuth = userAuthDao.findByUserIdAndRememberMe(userIdDigest, rememberMeDigest);
        System.out.println(userAuth.toString());
    }

    @Test
    public void testCookieLogin() {
        String userIdDigest = "9A93332EDDBE4375B6141D2870F03153";
        String rememberMeDigest = "eCmZ2W4S5N9H/JfjXSAQ+g==";
        UserService userService = new UserService();
        try {
            User user = userService.cookieLogin(userIdDigest, rememberMeDigest);
            System.out.println(user.toString());
        } catch (UserException e) {
            e.printStackTrace();
        }
    }
}
