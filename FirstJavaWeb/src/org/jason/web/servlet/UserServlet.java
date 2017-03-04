package org.jason.web.servlet;

import org.jason.domain.User;
import org.jason.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by JTrancender on 2017/3/4.
 */
@WebServlet(name = "/UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 在Servlet中依赖service，然后通过service完成功能，把结果保存到request中
         * 转发到jsp显示
         */

        UserService userService = new UserService();
        User user = userService.find();

        request.setAttribute("user", user);

        request.getRequestDispatcher("/user_show.jsp").forward(request, response);
    }
}
