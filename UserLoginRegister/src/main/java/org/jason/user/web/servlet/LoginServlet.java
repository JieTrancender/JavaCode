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
 * UserServlet层
 * Created by JTrancender on 2017/3/7.
 */
@WebServlet(name = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//请求编码
        response.setContentType("text/html;charset=utf-8");//响应编码

        //依赖UserService
        UserService userService = new UserService();

        /**
         * 1. 封装表单数据到User对象中
         */
        User user = CommonUtils.toBean(request.getParameterMap(), User.class);

        /**
         * 2. 校验验证码
         *   ①. 从Session域中获取正确的验证码
         *   ②. 调用userService的checkVerifyCode方法检查验证码
         *   ③. 得到异常，保存异常信息到request域中，转发到login.jgp中
         *   ④. 没有异常，向下运行
         */
        String paramCode = request.getParameter("verifyCode");

        try {
            userService.checkVerifyCode(user, paramCode);
        } catch (UserException e) {
            request.setAttribute("msg", e.getMessage());
            request.getRequestDispatcher("/user/login.jsp").forward(request, response);
        }

        /**
         * 3. 验证用户信息
         *   ①. 调用userService的login方法验证登录
         *   ②. 得到异常，保存异常信息到request域中，转发到login.jsp中
         *   ③. 没有异常，向下运行
         */

        String verifyCode = (String) request.getSession().getAttribute("verifyCode");

        if (!paramCode.equalsIgnoreCase(verifyCode)) {
            request.setAttribute("msg", "验证码错误");
            request.getRequestDispatcher("/user/login.jsp").forward(request, response);
            return;
        }










        /**
         * 1. 将表单数据封装到User对象中
         * 2. 调用userService的login方法传递form过去
         * 3. 得到异常，获取异常，保存到request域中，转发到login.jsp中
         * 4. 没有异常，跳转到主页
         */
//        try {
//            userService.login();
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
