package org.jason.user.web.servlet;

import org.jason.commons.VerifyCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by JTrancender on 2017/3/10.
 */
@WebServlet(name = "/VerifyServlet")
public class VerifyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 1. 生成图片
         * 2. 保存图片上的文本到session域中
         * 3. 将图片响应给客户端
         */
        VerifyCode verifyCode = new VerifyCode();
        BufferedImage bufferedImage = verifyCode.getImage();

        request.getSession().setAttribute("verifyCode", verifyCode.getText());
        verifyCode.output(bufferedImage, "JPEG", response.getOutputStream());
    }
}
