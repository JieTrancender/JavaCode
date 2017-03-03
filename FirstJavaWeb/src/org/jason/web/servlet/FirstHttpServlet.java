package org.jason.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by JTrancender on 2017/3/1.
 * 演示发送状态码
 */
@WebServlet(name = "/FirstHttpServlet")
public class FirstHttpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.sendError(404, "你访问的资源不存在，就不给你看！");
        System.out.println("FirstHttpServlet...");

        /**
         * 重定向：
         * 1. 设置Location
         * 2. 发送302状态码
         */
//        response.setHeader("Location", "/welcome/SecondHttpServlet");
//        response.setStatus(302);

        /**
         * 快速重定向方法
         */
//        response.sendRedirect("/welcome/SecondHttpServlet");

        /**
         * 发送响应体
         */
//        PrintWriter writer = response.getWriter();
//        writer.print("欢迎Jason登录！5秒钟后会自动跳转到主页！你看到的一定是乱码");

        /**
         * 设置Refresh的响应头
         */
//        response.setHeader("Refresh", "5;URL=/welcome/SecondHttpServlet");

        /**
         * 禁用浏览器缓存
         */
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("pragma", "no-cache");
        response.setDateHeader("expires", 0);
        response.setHeader("keywords", "keyword1, keyword2, keyword3");

        /**
         * 使用Referer请求头，来防盗链
         */
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String referer = request.getHeader("referer");
        String sitePart = request.getScheme() + getServletName();
//        String sitePart = "http://" + request.getServerName();

        if (referer != null && referer.startsWith(sitePart)) {
            out.println("正在处理你的请求");
        } else {
            request.getRequestDispatcher("session/login.jsp").forward(request, response);
        }
    }
}
