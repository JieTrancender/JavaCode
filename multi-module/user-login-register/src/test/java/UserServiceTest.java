import org.jason.commons.CommonUtils;
import org.jason.user.domain.User;
import org.jason.user.domain.UserAuth;
import org.jason.user.service.UserException;
import org.jason.user.service.UserService;
import org.junit.Test;

/**
 * Created by JTrancender on 2017/4/24.
 */
public class UserServiceTest {
    @Test
    public void testRegister() {
        UserAuth userAuth = new UserAuth(CommonUtils.uuid(), "phone", "18681700917", "JTrancender...");
        User user = new User("JieTrancender", "男", "images/avatar/default.jpg", userAuth);
        UserService userService = new UserService();
        try {
            userService.register(user);
            System.out.println(user.getIdentityType() + ":" + user.getIdentifier() + " 注册成功！");
        } catch (UserException ue) {
            System.err.println(ue.getMessage());
        }
    }

    @Test
    public void testLogin() {
        UserAuth userAuth = new UserAuth();
        userAuth.setIdentityType("email");
        userAuth.setIdentifier("ming-email@jie-trancender.org");
        userAuth.setCredentialDigest("ShaoJie@qq.com");

        UserService userService = new UserService();
        try {
            userService.login(userAuth);
            System.out.println(userAuth.getIdentityType() + ":" + userAuth.getIdentifier() + "登录成功！");
        } catch (UserException e) {
            e.printStackTrace();
        }
    }
}
