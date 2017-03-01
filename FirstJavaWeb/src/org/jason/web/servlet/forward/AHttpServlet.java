package org.jason.web.servlet.forward;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by JTrancender on 2017/3/1.
 *
 */
@WebServlet(name = "/AHttpServlet")
public class AHttpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("AHttpServlet");

        /**
         * 演示请求转发
         */
        response.setHeader("aaa", "AAA");//设置响应头
//
//        for (int i = 0; i < 24 * 1024 + 1; ++i) {
//            response.getWriter().print("a");//设置响应体
//        }
//
        request.setAttribute("userName", "JTrancender");
//        转发: 等同于调用BHttpServlet的service方法
        request.getRequestDispatcher("/BHttpServlet").forward(request, response);


        /**
         * 演示请求包含
         */
//        response.setHeader("aaa", "AAA");
//        response.getWriter().print("aaaa");
//
//        包含
//        request.getRequestDispatcher("/BHttpServlet").include(request, response);
    }
}
