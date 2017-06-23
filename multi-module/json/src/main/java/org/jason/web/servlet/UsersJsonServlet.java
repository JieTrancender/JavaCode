package org.jason.web.servlet;

import jason.user.domain.User;
import jason.user.service.UserService;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by JTrancender on 2017/6/22.
 */
@WebServlet(name = "UsersJsonServlet")
public class UsersJsonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");

        UserService userService = new UserService();
        ArrayList<User> userArrayList = userService.read();
        for (User user : userArrayList) {
            System.out.println(user);
        }

        JSONArray jsonArray = new JSONArray(userArrayList);
        System.out.println(jsonArray);
//        JSONObject jsonObjects = new JSONObject(userArrayList);
//        System.out.println(jsonObjects);


        String callbackName = request.getParameter("jsoncallback");
        String renderStr = callbackName + "(" + jsonArray.toString() + ")";

        PrintWriter printWriter = response.getWriter();
        printWriter.write(renderStr);
        printWriter.flush();
        printWriter.close();
    }
}
