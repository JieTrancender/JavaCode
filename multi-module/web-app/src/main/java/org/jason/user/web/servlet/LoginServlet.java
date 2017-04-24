package org.jason.user.web.servlet;

import org.jason.commons.CommonUtils;
import org.jason.user.domain.User;
import org.jason.user.domain.UserAuth;
import org.jason.user.service.UserException;
import org.jason.user.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by JTrancender on 2017/4/24.
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        UserService userService = new UserService();

        String identity_type = "email";
        UserAuth form = CommonUtils.toBean(request.getParameterMap(), UserAuth.class);
        form.setIdentityType(identity_type);

        //暂时未实现
        //String remember_me = request.getParameter("remember_me");
        //String verifyCode = request.getParameter("verifyCode");
        try {
            userService.login(form);
            User user = userService.find(form);

            HttpSession session = request.getSession();
            session.setAttribute("sessionUser", user);

            response.sendRedirect("/index.jsp");
        } catch (UserException ue) {
            request.setAttribute("formInfo", form);
            request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
            return;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LoginServlet#doGet");
        doPost(request, response);
    }
}
