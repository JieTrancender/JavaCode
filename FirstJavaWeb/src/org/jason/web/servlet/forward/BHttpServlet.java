package org.jason.web.servlet.forward;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by JTrancender on 2017/3/1.
 */
@WebServlet(name = "/BHttpServlet")
public class BHttpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 在获取参数之前，需要先调用request.setCharacterEncoding("utf-8")
         * 使用getParameter获取参数
         */
        request.setCharacterEncoding("utf-8");
        String userName = request.getParameter("userName");
        System.out.println(userName);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("BHttpServlet");
        System.out.println(request.getAttribute("userName"));
        response.getWriter().print("hello BHttpServlet");

        /**
         * tomcat8之前版本
         * 先获取来使用iso的错误字符串
         * 回退，使用utf-8重编
         */

//        String name = request.getParameter("userName");
//        byte[] b = name.getBytes("iso-8859-1");
//        name = new String(b, "utf-8");
//        System.out.println(name);

        //新版本
        System.out.println(request.getParameter("userName"));
    }
}
