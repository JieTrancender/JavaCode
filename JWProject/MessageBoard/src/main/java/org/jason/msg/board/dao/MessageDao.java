package org.jason.msg.board.dao;

import org.jason.msg.board.domain.Message;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by JTrancender on 2017/3/17.
 */
public interface MessageDao {
    public void add(Message msg) throws SQLException;
    public Message findByMessgeName(String msgName) throws SQLException;
    public List<Message> getMessages() throws SQLException;
}
