package org.jason.message.board.service;

import org.jason.message.board.dao.DaoFactory;
import org.jason.message.board.dao.MessageDao;
import org.jason.message.board.domain.Message;

import java.sql.SQLException;

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
        Message msg = messageDao.findByMessgeName(msgName);

        if (msg == null) {
            throw new MessageException("姓名为:" + msgName + "的留言信息不存在");
        }
        return msg;
    }
}
