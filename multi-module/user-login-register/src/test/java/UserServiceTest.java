import jason.common.tools.CommonUtils;
import jason.user.domain.User;
import jason.user.domain.UserAuth;
import jason.user.service.UserException;
import jason.user.service.UserService;
import org.junit.Test;

/**
 * Created by JTrancender on 2017/4/24.
 */
public class UserServiceTest {
    private UserService userService = new UserService();

    private void print(String str) {
        System.out.println(str);
    }

    @Test
    public void testCreate() {
        UserAuth userAuth = new UserAuth(CommonUtils.uuid(), "email", "ShaoJie2@qq.com", "JTrancender...", CommonUtils.getRememberMeDigest());
        User user = new User("JieTrancender", "男", "images/avatar/default.jpg", userAuth);
        try {
            userService.createUser(user);
        } catch (UserException ue) {
            print(ue.getMessage());
        }
    }

    @Test
    public void testReadUserAuth() {
        UserAuth userAuth = new UserAuth("", "email", "582865471@qq.com", "JTrancender...", null);
        try {
            User user = userService.readUserAuth(userAuth);
            System.out.println(user);
        } catch (UserException ue) {
            print(ue.getMessage());
        }
    }

    @Test
    public void testReadUserAuth2() {
        String userIdDigest = "983B0A664C5C4071B0C3E2559168905B";
        String rememberMeDigest = "lU810DeJkYmmCtR9EdgEXg==";
        try {
            User user = userService.readUserAuth(userIdDigest, rememberMeDigest);
            print(user.toString());
        } catch (UserException ue) {
            print(ue.getMessage());
        }
    }

    @Test
    public void testUpdateUserAuth() {
        UserAuth userAuth = new UserAuth("", "QQ", "317028773", "JTrancender...", null);
        try {
            User user = userService.readUserAuth(userAuth);
            print(user.toString());

            userService.updateUserAuth(userAuth, CommonUtils.getRememberMeDigest());
            user = userService.readUserAuth(userAuth);
            print(user.toString());
        } catch (UserException ue) {
            print(ue.getMessage());
        }
    }
}
