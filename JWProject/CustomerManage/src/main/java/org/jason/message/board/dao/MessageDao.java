package org.jason.message.board.dao;

import org.jason.message.board.domain.Message;

import java.sql.SQLException;

/**
 * Created by JTrancender on 2017/3/17.
 */
public interface MessageDao {
    public void add(Message msg) throws SQLException;
    public Message findByMessgeName(String msgName) throws SQLException;
}
