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
 */
@WebServlet(name = "/BServlet")
public class BServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 获取ServletContext对象
         * 调用其getAttribute方法完成获取数据
         */
        ServletContext application = this.getServletContext();
        String name = (String)application.getAttribute("name");
        System.out.println(name);
    }
}
