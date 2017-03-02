package org.jason.test;

import org.jason.commons.VerifyCode;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by JTrancender on 2017/3/2.
 */
public class MyTest {
    @Test
    public void dynamicVerify() throws IOException {
        VerifyCode verifyCode = new VerifyCode();
        verifyCode.output(verifyCode.getImage(), "JPEG", new FileOutputStream("F:/test.jpg"));
        System.out.println(verifyCode.getText());
    }
}
