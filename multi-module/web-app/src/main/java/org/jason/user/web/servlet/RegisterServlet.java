package org.jason.user.web.servlet;

import org.jason.commons.CommonUtils;
import org.jason.user.domain.User;
import org.jason.user.service.UserException;
import org.jason.user.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        //验证验证码 - 暂未实现

        //注册
        try {
            userService.register(form);
            response.getWriter().print("<h1>注册成功</h1>");
        } catch (UserException ue) {
            request.setAttribute("errMsg", ue.getMessage());
            request.setAttribute("formInfo", form);
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
