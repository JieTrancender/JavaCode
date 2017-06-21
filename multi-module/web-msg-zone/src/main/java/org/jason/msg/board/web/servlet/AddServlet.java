package org.jason.msg.board.web.servlet;

import jason.common.tools.CommonUtils;
import org.jason.msg.board.domain.Message;
import org.jason.msg.board.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
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

        try {
            messageService.addMessage(msg);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //response.sendRedirect("/AddServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MessageService messageService = new MessageService();

        try {
            List<Message> messageList  =  messageService.getMessages();
            Collections.reverse(messageList);
            request.setAttribute("msgList", messageList);
            request.setAttribute("msgListSize", messageList.size());
            request.getRequestDispatcher("/jsp/_msgs.jsp").forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
