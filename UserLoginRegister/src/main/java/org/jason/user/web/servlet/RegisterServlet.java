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

/**
 * Created by JTrancender on 2017/3/7.
 */
@WebServlet(name = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //依赖UserService
        UserService userService = new UserService();

        /**
         * 1. 封装表单数据到User对象中
         */
//        User from = CommonUtils::toBean(request.getParameterMap(), User.class);
        User form = CommonUtils.toBean(request.getParameterMap(), User.class);
        /**
         * 2. 调用userService的register方法，传递form过去
         * 3. 得到异常: 获取异常信息，保存到request域中，转发到register.jsp中
         * 4. 没有异常: 输出注册成功
         */
        try {
            userService.register(form);
            response.getWriter().print("<h1>注册成功</h1><a href='" + request.getContextPath() + "/user/login.jsp" + "'>点击这里去登录");
        } catch (UserException e) {
            //获取异常信息，保存到request域中
            request.setAttribute("msg", e.getMessage());
            //转发到register.jsp
            request.getRequestDispatcher("/user/register.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
