package org.jason.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by JTrancender on 2017/2/28.
 */
@WebServlet(name = "/EServlet")
public class EServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 获取ServletContext对象
         * 从ServletContext对象中获取名为count的属性
         * 如果存在：给访问量加1，然后保存回去
         * 如果不存在：说明第一次，想ServletContext中保存count并设置为1
         */
        ServletContext app = this.getServletContext();
        Integer count = (Integer)app.getAttribute("count");
        if (null == count) {
            app.setAttribute("count", 1);
        } {
            app.setAttribute("count", count + 1);
        }

        /**
         * 想浏览器输出
         * 需要使用响应对象
         */
        PrintWriter pw = response.getWriter();
        pw.print("<h1>" + count + "</h1>");
    }
}
