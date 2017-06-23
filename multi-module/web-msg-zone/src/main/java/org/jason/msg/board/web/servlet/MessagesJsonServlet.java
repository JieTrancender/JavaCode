package org.jason.msg.board.web.servlet;

import jason.common.tools.CommonUtils;
import jason.user.domain.User;
import jason.user.service.UserService;
import org.jason.msg.board.domain.Message;
import org.jason.msg.board.service.MessageException;
import org.jason.msg.board.service.MessageService;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by JTrancender on 2017/6/23.
 */
@WebServlet(name = "MessagesJsonServlet")
public class MessagesJsonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");

        String userId = request.getParameter("userId");
        if (userId != null) {
            CommonUtils.addCookie(response, "userId", userId);
        } else {
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + " = " + cookie.getValue());
                if (cookie.getName().equalsIgnoreCase("userId")) {
                    userId = cookie.getValue();
                    break;
                }
            }
        }

        MessageService messageService = new MessageService();
        UserService userService = new UserService();
        try {
            ArrayList<Message> messages = messageService.getMessages(userId);
            Collections.reverse(messages);

            ArrayList<User> users;

            JSONArray jsonArray = new JSONArray();
            JSONObject jsonObject;
            for (Message message : messages) {
                jsonObject = new JSONObject(message);
                users = userService.read(message.getFriendId());
                for (User user : users) {
                    jsonObject.put("name", user.getName());
                }
                jsonArray.put(jsonObject);
            }
            System.out.println(jsonArray);

            String callbackName = request.getParameter("jsoncallback");
            String renderStr = callbackName + "(" + jsonArray.toString() + ")";

            PrintWriter printWriter = response.getWriter();
            printWriter.write(renderStr);
            printWriter.flush();
            printWriter.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (MessageException e) {
            e.printStackTrace();
        }
    }
}
