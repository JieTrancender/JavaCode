package org.jason.test;

import org.jason.commons.VerifyCode;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by JTrancender on 2017/3/2.
 */
public class MyTest {
    @Test
    public void dynamicVerify() throws IOException {
        /**
         * 1. 创建图片缓冲区
         * 2. 设置其宽高
         * 3. 得到这个图片的绘制环境(得到画笔)
         * 4. 保存起来
         */
        BufferedImage bufferImage = new BufferedImage(70, 35, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) bufferImage.getGraphics();
        g.setColor(Color.WHITE);//把环境设置为红色
        g.fillRect(0, 0, 70, 35);//填充矩形
        g.setColor(Color.RED);
        g.drawString("Hello", 2, 35 - 2);//向图片上写入字符串

        ImageIO.write(bufferImage, "JPEG", new FileOutputStream("F:/verify.jpg"));

        VerifyCode verifyCode = new VerifyCode();
        ImageIO.write(verifyCode.getImage(), "JPEG", new FileOutputStream("F:/test.jpg"));
        System.out.println(verifyCode.getText());
    }
}
