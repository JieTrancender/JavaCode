package org.jason.user.web.servlet;

import org.jason.user.service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by JTrancender on 2017/4/21.
 */
@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("UserServlet#doPost");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();
        Map<String, Integer> ipContextMap = (HashMap<String, Integer>) servletContext.getAttribute("ipContextMap");
        if (ipContextMap != null) {
            System.out.println(ipContextMap);
        } else {
            System.out.println("ipContextMap is null");
        }
        for (Map.Entry<String, Integer> entry : ipContextMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("ipContextMap.length = " + ipContextMap.size());
        System.out.println("UserServlet#doGet");
        Enumeration enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()) {
            String paramName = (String) enumeration.nextElement();
            String[] values = request.getParameterValues(paramName);
            System.out.print(paramName + "=");
//            System.out.println(paramName + "=" + values.toString());
            for (int i = 0; i < values.length; ++i) {
                System.out.print(values[i] + ";");
            }
            System.out.println("");
        }

        UserService userService = new UserService();

    }
}
