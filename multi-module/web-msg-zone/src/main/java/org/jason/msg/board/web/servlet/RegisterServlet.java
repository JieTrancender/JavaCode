package org.jason.msg.board.web.servlet;

import jason.common.tools.CommonUtils;
import jason.user.domain.User;
import jason.user.service.UserException;
import jason.user.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by JTrancender on 2017/4/24.
 */
@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService();

        User form = CommonUtils.toBean(request.getParameterMap(), User.class);
        form.getUserAuth().addUserId();

        //This should refactor
        String identity_type = "email";
        form.setIdentityType(identity_type);
        String password = request.getParameter("password");
        form.setCredentialDigest(password);
        userService.rememberLogin(form.getUserAuth());

        //verifyCode - this part hasn't done

        try {
//            userService.register(form);
//            userService.login(form.getUserAuth());
            userService.createUser(form);
            userService.readUserAuth(form.getUserAuth());
            userService.rememberLogin(form.getUserAuth());
            User current = userService.find(form.getUserAuth());
            HttpSession session = request.getSession();
            session.setAttribute("current", current);
            CommonUtils.addCookie(response, "userIdDigest", current.getUserAuth().getUserId());
            CommonUtils.addCookie(response, "rememberMeDigest", current.getUserAuth().getRememberMeDigest());
            /*Cookie cookieIdentifier = new Cookie("identifier", form.getIdentifier());
            cookieIdentifier.setMaxAge(60 * 60 * 24 * 30);
            cookieIdentifier.setPath("/");
            response.addCookie(cookieIdentifier);
            Cookie cookiePassword = new Cookie("password", password);
            cookiePassword.setMaxAge(60 * 60 * 24 * 30);
            cookiePassword.setPath("/");
            response.addCookie(cookiePassword);*/
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
