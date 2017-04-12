import org.junit.Test;

/**
 * Created by JTrancender on 2017/4/12.
 */
public class LoginTypeTest {
    @Test
    public void testLoginType() {
        String str = "582865471@qq.comfasf";

        String em = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";
        String ph = "^[1][358][0-9]{9}";

        System.out.println(str.matches(em));
        System.out.println(str.matches(ph));
        if (str.matches(em)) {
            System.out.println("email");
        } else if (str.matches(ph)) {
            System.out.println("phone");
        } else {
            System.out.println("User Name");
        }
    }
}
