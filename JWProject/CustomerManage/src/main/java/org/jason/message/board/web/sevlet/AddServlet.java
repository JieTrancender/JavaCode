package org.jason.message.board.web.sevlet;

import org.jason.commons.CommonUtils;
import org.jason.message.board.domain.Message;
import org.jason.message.board.service.MessageException;
import org.jason.message.board.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

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

        System.out.println(msg.toString());

        try {
            messageService.addMessage(msg);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MessageService messageService = new MessageService();

//        String userName = (String) request.getAttribute("userName");
        String userName = request.getParameter("userName");
        System.out.println(userName);
        try {
            Message msg = messageService.getMessage(userName);
            request.setAttribute("msg", msg);
            System.out.println(msg.toString());
            request.getRequestDispatcher("/jsp/show-message.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (MessageException e) {
            e.printStackTrace();
        }
    }
}
