package org.jason.course.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by JTrancender on 2017/3/10.
 */
@WebServlet(name = "/HttpHeaderServlet")
public class HttpHeaderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String headerName = (String) headers.nextElement();
            System.out.println(headerName + ": " + request.getHeader(headerName));
        }

        request.setAttribute("userName", "Jason");
        //请求转发
        request.getRequestDispatcher("/course/get_header.jsp").forward(request, response);

    }
}
