package org.jason.msg.board.web.servlet;

import org.jason.msg.board.domain.Message;
import org.jason.msg.board.domain.MessageOld;
import org.jason.msg.board.service.MessageException;
import org.jason.msg.board.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by JTrancender on 2017/6/21.
 */
@WebServlet(name = "TestServlet")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MessageService messageService = new MessageService();
        String userId = request.getParameter("userId");
        try {
            List<Message> messageList = messageService.getMessages(userId);
            Iterator<Message> messageIterator = messageList.iterator();

            while (messageIterator.hasNext())
            {
                System.out.println(messageIterator.next());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (MessageException e) {
            e.printStackTrace();
        }
    }
}
