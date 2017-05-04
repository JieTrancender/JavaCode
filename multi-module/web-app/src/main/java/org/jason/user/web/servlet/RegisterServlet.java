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
import java.util.HashMap;
import java.util.Map;

/**
 * Created by JTrancender on 2017/4/24.
 */
@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //依赖UserService
        UserService userService = new UserService();

        //封装表单数据到User对象中
        User form = CommonUtils.toBean(request.getParameterMap(), User.class);
        form.getUserAuth().addUserId();

        String identity_type = "email";
        form.setIdentityType(identity_type);
        String password = request.getParameter("password");
        form.setCredentialDigest(password);

        System.out.println(form.toString());

        //验证验证码 - 暂未实现

        //注册
        try {
            userService.register(form);
            HttpSession session = request.getSession();
            session.setAttribute("current", form);
//            Cookie cookie = new Cookie("current", )
            Cookie cookieIdentifier = new Cookie("identifier", form.getIdentifier());
            cookieIdentifier.setMaxAge(60 * 60 * 24 * 30);
            cookieIdentifier.setPath("/");
            response.addCookie(cookieIdentifier);
            Cookie cookiePassword = new Cookie("password", password);
            cookiePassword.setMaxAge(60 * 60 * 24 * 30);
            cookiePassword.setPath("/");
            response.addCookie(cookiePassword);
            response.sendRedirect("/index.jsp");
//            request.getRequestDispatcher("/index.jsp").forward(request, response);
//            response.getWriter().print("<h1>注册成功</h1>");
        } catch (UserException ue) {
            request.setAttribute("alertMsg", ue.getMessage());
            request.setAttribute("userInfo", form);
            request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
        }
        System.out.println(form.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
//        System.out.println("Register#doGet");
//        doPost(request, response);
    }
}
