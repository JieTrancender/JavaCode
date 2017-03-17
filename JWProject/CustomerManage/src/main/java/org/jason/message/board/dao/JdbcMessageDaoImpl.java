package org.jason.message.board.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.jason.commons.TxQueryRunner;
import org.jason.message.board.domain.Message;

import java.sql.SQLException;

/**
 * Created by JTrancender on 2017/3/17.
 */
public class JdbcMessageDaoImpl implements MessageDao {
    public void add(Message msg) throws SQLException {
        QueryRunner queryRunner = new TxQueryRunner();
        String sql = "insert into message(name, phone, email, title, content) values(?,?,?,?,?)";
        Object[] params = {msg.getName(), msg.getPhone(), msg.getEmail(), msg.getTitle(), msg.getContent()};

        queryRunner.update(sql, params);
    }

    public Message findByMessgeName(String msgName) throws SQLException {
        QueryRunner queryRunner = new TxQueryRunner();
        String sql = "select * from message where name=?";
        Object[] params = {msgName};

        Message msg = queryRunner.query(sql, new BeanHandler<Message>(Message.class), params);
        return msg;
    }
}
