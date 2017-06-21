package org.jason.msg.board.dao;

import org.jason.msg.board.domain.Message;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by JTrancender on 2017/3/17.
 */
public interface MessageDao {
    void add(Message msg) throws SQLException;
    Message findByMessageName(String msgName) throws SQLException;
    List<Message> getMessages() throws SQLException;
}
