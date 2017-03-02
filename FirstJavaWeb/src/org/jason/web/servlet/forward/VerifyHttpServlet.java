package org.jason.web.servlet.forward;

import org.jason.commons.VerifyCode;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by JTrancender on 2017/3/2.
 */
@WebServlet(name = "/VerifyHttpServlet")
public class VerifyHttpServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 1. 生成图片
         * 2. 保存图片上的文本到session域中
         * 3. 把图片响应给客户端
         */
        VerifyCode verifyCode = new VerifyCode();
        BufferedImage bufferedImage = verifyCode.getImage();

        request.getSession().setAttribute("sessionVerifyCode", verifyCode.getText());//保存图片上下文到Session域中
        ImageIO.write(bufferedImage, "JPEG", response.getOutputStream());
    }
}
