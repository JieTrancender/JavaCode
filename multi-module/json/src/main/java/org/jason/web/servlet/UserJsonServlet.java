package org.jason.web.servlet;

import jason.user.domain.User;
import jason.user.service.UserService;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by JTrancender on 2017/6/22.
 */
@WebServlet(name = "UserJsonServlet")
public class UserJsonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");

//        String userId = request.getParameter("userId");
        UserService userService = new UserService();
        User user = userService.read("email", "582865471@qq.com");
//        User user = userService.read(userId).get(0);
        System.out.println(user);

        JSONObject jsonObject = new JSONObject(user);
        System.out.println(jsonObject);

        String callbackName = request.getParameter("jsoncallback");
        String renderStr = callbackName + "(" + jsonObject.toString() + ")";

        PrintWriter printWriter = response.getWriter();
        printWriter.write(renderStr);
        printWriter.flush();
        printWriter.close();
    }
}
