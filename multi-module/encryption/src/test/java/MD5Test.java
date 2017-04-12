import org.jason.MD5;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by JTrancender on 2017/4/12.
 */
public class MD5Test {
    @Test
    public void testMD5() {
        String str = "0123456789";
        try {
            System.out.println(MD5.encoderByMd5(str));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
