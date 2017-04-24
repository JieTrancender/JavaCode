package org.jason.web.servlet;

import org.jason.SimpleService;
import org.jason.user.dao.JdbcUserDaoImpl;
import org.jason.user.dao.UserDao;
import org.jason.user.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by JTrancender on 2017/4/12.
 */
public class SimpleServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String serviceDesc = SimpleService.getServiceDescription();

        UserDao userDao = new JdbcUserDaoImpl();
        User user = userDao.find("email", "jie-email@jie-trancender.org");
        System.out.println(user);
        out.println(user.toString());
        out.println(serviceDesc);
        out.flush();
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("Compiler", "Idea");
        cookie.setMaxAge(60 * 60 * 24 * 30);
        cookie.setPath("/");
        resp.addCookie(cookie);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
        //super.doPost(req, resp);
    }
}
