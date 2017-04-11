package org.jason.msg.board.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.jason.commons.TxQueryRunner;
import org.jason.msg.board.domain.Message;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by JTrancender on 2017/3/17.
 */
public class JdbcMessageDaoImpl implements MessageDao {
    public void add(Message msg) throws SQLException {
        QueryRunner queryRunner = new TxQueryRunner();
        String sql = "insert into guestbook(name, phone, email, title, content, time) values(?,?,?,?,?,?)";
        Object[] params = {msg.getName(), msg.getPhone(), msg.getEmail(), msg.getTitle(), msg.getContent(), msg.getTime()};

        queryRunner.update(sql, params);
    }

    public Message findByMessgeName(String msgName) throws SQLException {
        QueryRunner queryRunner = new TxQueryRunner();
        String sql = "select name, phone, email, title, content, time from guestbook where name=?";
        Object[] params = {msgName};

        Message msg = queryRunner.query(sql, new BeanHandler<Message>(Message.class), params);
        return msg;
    }

    public List<Message> getMessages() throws SQLException {
        QueryRunner queryRunner = new TxQueryRunner();
        String sql = "select name, phone, email, title, content, time from guestbook";

        List<Message> messageList = queryRunner.query(sql, new BeanListHandler<Message>(Message.class));
        return messageList;
    }
}
