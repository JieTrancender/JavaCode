package org.jason.web.servlet.forward;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by JTrancender on 2017/3/2.
 */
@WebServlet(name = "/LoginHttpServlet")
public class LoginHttpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 校验验证码
         *   1. 从Session域中获取正确的验证码
         *   2. 从表单中获取用户填写的验证码
         *   3. 比较
         *   4. 相同向下运行，否则保存错误信息到request域，转发到login.jsp
         */
        String sessionCode = (String) request.getSession().getAttribute("sessionVerifyCode");
        String paramCode = request.getParameter("verifyCode");

        if (!paramCode.equalsIgnoreCase(sessionCode)) {
            request.setAttribute("msg", "验证码错误");
            request.getRequestDispatcher("/session/login.jsp").forward(request, response);
            return;
        }

        /**
         * 获取表单数据
         */
        //处理中文问题
        request.setCharacterEncoding("utf-8");
        //获取
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        /**
         * 校验用户名和密码是否正确
         */
        if ("Jason".equalsIgnoreCase(userName)) {
            /**
             * 附加项: 把用户名保存到Cookie中，发送给客户端浏览器
             * 当再次打开login.jsp是，login.jsp中会读取request中的Cookie
             */
            Cookie cookie = new Cookie("userName", userName);
            cookie.setMaxAge(60 * 60 * 24);//设置Cookie命长为1天
            response.addCookie(cookie);

            /**
             * 如果成功
             *   保存用户信息到Session中
             *   重定向到index.jsp
             */

            HttpSession session = request.getSession();
            session.setAttribute("userName", userName);
            //重定向到index.jsp
            response.sendRedirect("/session/index.jsp");
        } else {
            /**
             * 如果失败
             *   保存错误信息到request域中
             *   转发到login.jsp中
             */
            request.setAttribute("msg", "用户名或密码错误");
            RequestDispatcher qr = request.getRequestDispatcher("/session/login.jsp");
            qr.forward(request, response);  //转发
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
