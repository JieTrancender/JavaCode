package org.jason.msg.board.web.servlet;

import jason.common.tools.CommonUtils;
import jason.user.domain.User;
import org.jason.msg.board.domain.Message;
import org.jason.msg.board.domain.MessageOld;
import org.jason.msg.board.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/**
 * UserServlet层
 * Created by JTrancender on 2017/3/7.
 */
@WebServlet(name = "/AddServlet")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");//请求编码
        response.setContentType("text/html;charset=utf-8");//响应编码

        MessageService messageService = new MessageService();

        Message msg = CommonUtils.toBean(request.getParameterMap(), Message.class);
        System.out.println(msg);

//        String userId = request.getParameter("userId");
//        msg.setHostId(userId);
        Enumeration<String> enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement();
            System.out.println(key + " = " + request.getParameter(key));
        }

        User user = (User) request.getSession().getAttribute("current");
        if (user == null || user.getUserId() == null) {
            request.setAttribute("alertMsg", "未登录，无法留言，请先登录!");
            request.getRequestDispatcher("/zone/jsp/login.jsp").forward(request, response);
        }
        msg.setFriendId(user.getUserId());
        System.out.println(msg);

        try {
            messageService.addMessage(msg);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //response.sendRedirect("/AddServlet");
//        String url = request.getHeader("Referer");
//        if (url != null) {
//            request.getRequestDispatcher(url).forward(request, response);
//        }
//        request.getRequestDispatcher("/zone/index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MessageService messageService = new MessageService();

        String userId = request.getParameter("userId");
        System.out.println("userId = " + request.getParameter("userId"));
        try {
            ArrayList<Message> messages =  messageService.getMessages(userId);
            Collections.reverse(messages);

            for (Message message : messages) {
                System.out.println(message);
            }

            request.setAttribute("msgArrayList", messages);
            request.setAttribute("msgArrayListSize", messages.size());
            request.getRequestDispatcher("/jsp/_msgs.jsp?userId=" +  userId).forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
