package org.jason.course.web.servlet;


import org.jason.commons.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by JTrancender on 2017/3/15.
 */
@WebServlet(name = "/ABaseServlet")
public class ABaseServlet extends BaseServlet {
    public String func1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("func1...");
        return "f:/index.jsp";
    }

    public String func2(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("func2...");
        return "r:/index.jsp";
    }

    public String editUser(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("editUser...");
        return "d:/index.jsp";
    }

    public String func3(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("func3...");
        return null;
    }
}
