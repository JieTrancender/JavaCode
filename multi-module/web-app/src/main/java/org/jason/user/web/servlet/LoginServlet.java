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
import java.util.Enumeration;

/**
 * Created by JTrancender on 2017/4/24.
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        UserService userService = new UserService();

        Enumeration enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()) {
            String key= (String) enumeration.nextElement();
            String value = request.getParameter(key);
//            String v = request.getPa
            System.out.println(key + ":" + value);
        }

        String identity_type = "email";
        UserAuth form = CommonUtils.toBean(request.getParameterMap(), UserAuth.class);
        form.setIdentityType(identity_type);

        String credential = request.getParameter("password");
        form.setCredentialDigest(credential);



        System.out.println(credential + "->" + form.getCredentialDigest());

        System.out.println(form.toString());

        //暂时未实现
        //String remember_me = request.getParameter("remember_me");
        //String verifyCode = request.getParameter("verifyCode");
        try {
            userService.login(form);
            User user;
//            User user = userService.find(form);

            String remember_me = request.getParameter("remember_me");
            System.out.println("remember_me = " + remember_me);
            if (remember_me != null && remember_me.equals("on")) {
                userService.rememberLogin(form);
                user = userService.find(form);
                System.out.println(user.toString());
                System.out.println("LoginServlet(rememberMeDigest):" + user.getUserAuth().getRememberMeDigest());

                Cookie userIdDigest = new Cookie("userIdDigest", user.getUserAuth().getUserId());
                userIdDigest.setMaxAge(60 * 60 * 24 * 30);
                userIdDigest.setPath("/");
                response.addCookie(userIdDigest);

                Cookie rememberMeDigest = new Cookie("rememberMeDigest", user.getUserAuth().getRememberMeDigest());
                rememberMeDigest.setMaxAge(60 * 60 * 24 * 30);
                rememberMeDigest.setPath("/");
                response.addCookie(rememberMeDigest);
            } else {
                userService.forgetLogin(form);
                user = userService.find(form);
                System.out.println(user.toString());
                removeCookie(request, response, "userIdDigest");
                removeCookie(request, response, "rememberMeDigest");
            }

            HttpSession session = request.getSession();
            session.setAttribute("current", user);


            response.sendRedirect("/index.jsp");
        } catch (UserException ue) {
            request.setAttribute("formInfo", form);
            request.setAttribute("alertMsg", "登录失败，请重新登录！");
            request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService();

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("current");
        userService.forgetLogin(user.getUserAuth());

        session.setAttribute("current", null);
        removeCookie(request, response, "userIdDigest");
        removeCookie(request, response, "rememberMeDigest");
        response.sendRedirect("/index.jsp");
    }

    private void removeCookie(HttpServletRequest request, HttpServletResponse response, String cookieName) {
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies) {
            if (cookie.getName().equalsIgnoreCase(cookieName)) {
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
                break;
            }
        }
    }
}
