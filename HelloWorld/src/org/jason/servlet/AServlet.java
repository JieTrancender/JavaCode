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
 * 演示向ServletContext中保存数据
 */

@WebServlet(name = "/AServlet")
public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        /**
         * 获取ServletContext对象
         * 调用其setAttribute方法完成保存数据
         */
        ServletContext application = this.getServletContext();
        application.setAttribute("name", "Jason");
    }
}
