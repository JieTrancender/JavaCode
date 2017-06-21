package org.jason.msg.board.service;

import org.jason.msg.board.dao.DaoFactory;
import org.jason.msg.board.dao.MessageDao;
import org.jason.msg.board.domain.Message;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by JTrancender on 2017/3/17.
 */
public class MessageService {
    MessageDao messageDao = DaoFactory.getMessageDao();

    public void addMessage(Message msg) throws SQLException, MessageException {
        messageDao.add(msg);

        Message message = getMessage(msg.getName());

        if (message != null) {
            System.out.println("增加msg成功");
        }
    }

    public Message getMessage(String msgName) throws SQLException, MessageException {
        Message msg = messageDao.findByMessageName(msgName);

        if (msg == null) {
            throw new MessageException("姓名为:" + msgName + "的留言信息不存在");
        }
        return msg;
    }

    public List<Message> getMessages() throws SQLException, MessageException {
        List<Message> messageList = messageDao.getMessages();

        if (messageList == null) {
            throw new MessageException("数据库中没有message记录！");
        }
        return messageList;
    }
}
