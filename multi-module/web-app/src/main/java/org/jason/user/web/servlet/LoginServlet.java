package org.jason.user.web.servlet;

import org.jason.commons.CommonUtils;
import org.jason.user.domain.User;
import org.jason.user.domain.UserAuth;
import org.jason.user.service.UserException;
import org.jason.user.service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

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
        form.setCredentialDigest(credential);

        //This part hasn't done.
        //String verifyCode = request.getParameter("verifyCode");
        try {
//            userService.login(form);
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
        CommonUtils.removeCookie(request, response, "userIdDigest");
        CommonUtils.removeCookie(request, response, "rememberMeDigest");
        response.sendRedirect("/index.jsp");
    }
}
