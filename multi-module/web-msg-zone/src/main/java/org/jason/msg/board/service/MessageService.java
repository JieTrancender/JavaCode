package org.jason.msg.board.service;

import org.jason.msg.board.dao.DaoFactory;
import org.jason.msg.board.dao.MessageDao;
import org.jason.msg.board.domain.Message;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JTrancender on 2017/3/17.
 */
public class MessageService {
    private MessageDao messageDao = DaoFactory.getMessageDao();

    public void addMessage(Message msg) throws SQLException, MessageException {
        messageDao.create(msg);

        List<Message> messageList = messageDao.read(msg.getHostId(), msg.getFriendId());

        if (messageList != null) {
            System.out.println("增加msg成功");
        }
    }

    public ArrayList<Message> getMessages(String hostId) throws SQLException, MessageException {
        ArrayList<Message> messageList = messageDao.read(hostId);

        if (messageList == null) {
            throw new MessageException("数据库中没有message记录！");
        }
        return messageList;
    }
}
