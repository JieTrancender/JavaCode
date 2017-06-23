package org.jason.msg.board.web.servlet;

import jason.common.tools.CommonUtils;
import jason.user.domain.User;
import jason.user.domain.UserAuth;
import jason.user.service.UserException;
import jason.user.service.UserService;

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
        UserService userService = new UserService();

        String identity_type = "email";
        UserAuth form = CommonUtils.toBean(request.getParameterMap(), UserAuth.class);
        form.setIdentityType(identity_type);

        //This can refactor by add method UserAuth::encodingCredential();
        String credential = request.getParameter("password");
        form.setCredential(credential);

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie);
        }

        try {
            userService.readUserAuth(form);
            User user;

            String remember_me = request.getParameter("remember_me");
            if (remember_me != null && remember_me.equals("on")) {
                userService.rememberLogin(form);
                user = userService.find(form);

                CommonUtils.addCookie(response, "userIdDigest", user.getUserAuth().getUserId());
                CommonUtils.addCookie(response, "rememberMeDigest", user.getUserAuth().getRememberMeDigest());
            } else {
                userService.forgetLogin(form);
                user = userService.find(form);
                CommonUtils.removeCookie(request, response, "userIdDigest");
                CommonUtils.removeCookie(request, response, "rememberMeDigest");
            }

            HttpSession session = request.getSession();
            session.setAttribute("current", user);

            response.sendRedirect("/zone/index.jsp");
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
        CommonUtils.removeCookie(request, response, "userIdDigest");
        CommonUtils.removeCookie(request, response, "rememberMeDigest");
        response.sendRedirect("/zone/index.jsp");
    }
}
