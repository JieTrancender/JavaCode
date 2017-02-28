package org.jason.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by JTrancender on 2017/2/28.
 * 演示ServletContext获取公共的初始化参数
 */
@WebServlet(name = "/CServlet")
public class CServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 得到ServletContext
         * 调用它getInitParameter(String)得到初始化参数
         */
        ServletContext app = this.getServletContext();
        String value = app.getInitParameter("context-param");
        System.out.println(value);
    }
}
