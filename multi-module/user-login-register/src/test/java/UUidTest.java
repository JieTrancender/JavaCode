import jason.common.tools.CommonUtils;
import org.junit.Test;

/**
 * Created by JTrancender on 2017/4/24.
 */
public class UUidTest {
    @Test
    public void testUUid() {
        String uuid = CommonUtils.uuid();
        System.out.println("uuid = " + uuid);
    }

    @Test
    public void testEncoderByMd5() {
        String password = "ShaoJie@qq.com";
        try {
            String digest = CommonUtils.encoderByMd5(password);
            System.out.println(CommonUtils.encoderByMd5(password));
            String key = "JTrancender...";
            System.out.println(CommonUtils.checkPassword(key, digest));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
