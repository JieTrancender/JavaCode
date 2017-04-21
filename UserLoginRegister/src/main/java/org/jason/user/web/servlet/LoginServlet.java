package org.jason.user.web.servlet;

import org.jason.commons.CommonUtils;
import org.jason.user.domain.User;
import org.jason.user.service.UserException;
import org.jason.user.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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

        System.out.println("test----------------");
        System.out.println(user.toString());

        /**
         * 2. 校验验证码
         *   ①. 从Session域中获取正确的验证码
         *   ②. 调用userService的checkVerifyCode方法检查验证码
         *   ③. 得到异常，保存异常信息到request域中，转发到login.jgp中
         *   ④. 没有异常，向下运行
         */
        String verifyCode = (String) request.getSession().getAttribute("verifyCode");

        try {
            userService.checkVerifyCode(user, verifyCode);

            /**
             * 附加项:将用户名保存到Cookie中，发送给客户端浏览器
             * 当再次打开login.jsp时，login.jsp中会读取request中的Cookie
             */
            Cookie cookie = new Cookie("userName", user.getUserName());
            cookie.setMaxAge(60 * 60 * 24 * 30);  //设置Cookie的生存时长为一个月
            response.addCookie(cookie);
        } catch (UserException e) {
            request.setAttribute("msg", e.getMessage());
            /**
             * 附加项: 将user对象信息封装到request域中，发生错误回退登录页面时自动输入登录数据
             */
            request.setAttribute("userInfo", user);
            request.getRequestDispatcher("/user/login.jsp").forward(request, response);
            return;
        }

        /**
         * 3. 验证用户信息
         *   ①. 调用userService的login方法验证登录
         *   ②. 得到异常，保存异常信息到request域中，转发到login.jsp中
         *   ③. 没有异常，向下运行
         */

        try {
            userService.login(user);

            /**
             * 4. 登录成功
             *   ①. 保存用户信息到Session中
             *   ②. 重定向到welcome.jsp
             */
            HttpSession session = request.getSession();
            session.setAttribute("sessionUser", user.getUserName());

            response.sendRedirect("/user/welcome.jsp");
        } catch (UserException e) {
            request.setAttribute("msg", e.getMessage());
            /**
             * 附加项: 将user对象信息封装到request域中，发生错误回退登录页面时自动输入登录数据
             */
            request.setAttribute("userInfo", user);
            request.getRequestDispatcher("/user/login.jsp").forward(request, response);
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/user/login.jsp").forward(request, response);
    }
}
