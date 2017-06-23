package org.jason.msg.board.dao;

import org.jason.msg.board.domain.Message;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by JTrancender on 2017/3/17.
 */

public interface MessageDao {
    void create(Message msg) throws SQLException;
//    Message read(String msgName) throws SQLException;
    ArrayList<Message> read(String hostId, String friendId) throws SQLException;
    ArrayList<Message> read(String hostId) throws SQLException;
}
