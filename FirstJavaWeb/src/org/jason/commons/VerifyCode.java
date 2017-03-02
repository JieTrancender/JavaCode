package org.jason.commons;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * Created by JTrancender on 2017/3/2.
 */
public class VerifyCode {
    private int width = 70;
    private int height = 35;
    private Random random = new Random();
    private String[] fontNames = {"宋体", "华文楷体", "黑体", "微软雅黑", "楷体_GB2312"};
    private String codes = "23456789abcdefghjkmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private Color bgColor = new Color(255, 255, 255);
    private String text;

    private Color randomColor() {
        int red = random.nextInt(150);
        int green = random.nextInt(150);
        int blue = random.nextInt(150);
        return new Color(red, green, blue);
    }

    private Font randomFont() {
        int index = random.nextInt(fontNames.length);
        String fontName = fontNames[index];
        int style = random.nextInt(4);
        int size = random.nextInt(5) + 24;
        return new Font(fontName, style, size);
    }

    private void drawLine(BufferedImage image) {
        int num = 3;
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        for (int i = 0; i < num; ++i) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);
            g2.setStroke(new BasicStroke(1.5F));
            g2.setColor(Color.BLUE);
            g2.drawLine(x1, y1, x2, y2);
        }
    }

    private char randomChar() {
        int index = random.nextInt(codes.length());
        return codes.charAt(index);
    }

    private BufferedImage createImage() {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        g2.setColor(this.bgColor);
        g2.fillRect(0, 0, width, height);
        return image;
    }

    public BufferedImage getImage() {
        BufferedImage image = createImage();
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 4; ++i) {
            String s = randomChar() + "";
            stringBuilder.append(s);
            float x = i * 1.0F * width / 4;
            g2.setFont(randomFont());
            g2.setColor(randomColor());
            g2.drawString(s, x, height - 5);
        }
        this.text = stringBuilder.toString();
        drawLine(image);
        return image;
    }

    public String getText() {
        return text;
    }

    public void output(BufferedImage bufferedImage, String fomat, OutputStream outputStream) throws IOException {
        ImageIO.write(bufferedImage, fomat, outputStream);
    }
}
