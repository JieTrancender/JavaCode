package org.jason.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

/**
 * Created by JTrancender on 2017/3/1.
 */
@WebServlet(name = "/SecondHttpServlet")
public class SecondHttpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String[] hobby = request.getParameterValues("hobby");

        System.out.println(userName + ", " + password + ", " + Arrays.toString(hobby));

        /**
         * 测试获取所有请求参数的名称
         */
        Enumeration names = request.getParameterNames();
        while (names.hasMoreElements()) {
            System.out.println(names.nextElement());
        }

        /**
         * 获取所有请求参数，封装到Map中
         */
        Map<String, String[]> map = request.getParameterMap();
        for(String name : map.keySet()) {
            String[] values = map.get(name);
            System.out.println(name + ": " + Arrays.toString(values));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("SecondHttpServlet...");

        /**
         * 字符流和字节流不能混用
         */
//        response.getWriter().print("Welcome Jason..");

//        String s = "Hello JTrancender...";
//        byte[] bytes = s.getBytes();
//        response.getOutputStream().write(bytes);

        /**
         * 演示响应字节数据
         */
//        String path = "F:/ming_rong.png";
//        FileInputStream in = new FileInputStream(path);
//        byte[] bytes;
//        try {
//            bytes = readInputStream(in);
//        } catch (Exception e) {
//            bytes = null;
//            e.printStackTrace();
//        }
//
//        response.getOutputStream().write(bytes);

        /**
         * 获取客户端IP地址、获取请求方式、获取User-Agent，得到客户端信息
         * User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64; rv:51.0) Gecko/20100101 Firefox/51.0
         */
        String addr = request.getRemoteAddr();
        System.out.println("IP: " + addr);
        System.out.println("请求方式: " + request.getMethod());//获取请求方式

        String userAgent = request.getHeader("User-Agent");
        if (userAgent.toLowerCase().contains("chrome")) {
            System.out.println("你好: " + addr + "，你用的是谷歌浏览器");
        } else if (userAgent.toLowerCase().contains("firefox")) {
            System.out.println("你好: " + addr + "，你用的是火狐浏览器");
        } else if (userAgent.toLowerCase().contains("msie")) {
            System.out.println("你好: " + addr + "，你用的是IE浏览器");
        }
        System.out.println("User-Agent: " + userAgent);

        /**
         * 通过request来获取url的相关方法
         */
        response.getWriter().print(request.getScheme() + "<br/>");//获取请求协议
        response.getWriter().print(request.getServerName() + "<br/>");
        response.getWriter().print(request.getServerPort() + "<br/>");
        response.getWriter().print(request.getContextPath() + "<br/>");
        response.getWriter().print(request.getServletPath() + "<br/>");
        response.getWriter().print(request.getQueryString() + "<br/>");
        response.getWriter().print(request.getRequestURL() + "<br/>");

        /**
         * 使用Referer请求头，来防盗链
         */
        String referer = request.getHeader("Referer");
        System.out.println(referer);
        if (referer == null || !referer.contains("localhost")) {
            System.out.println("http://baidu.com");
        } else {
            System.out.println("hello...");
        }

        /**
         *获取请求头参数
         */
        System.out.println("GET: " + request.getParameter("xxx"));
        System.out.println("GET: " + request.getParameter("yyy"));
    }

    public static byte[] readInputStream(InputStream inputStream) throws Exception {
        byte[] buffer = new byte[1024];
        int len = -1;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
        }
        outputStream.close();
        inputStream.close();
        return outputStream.toByteArray();
    }
}
