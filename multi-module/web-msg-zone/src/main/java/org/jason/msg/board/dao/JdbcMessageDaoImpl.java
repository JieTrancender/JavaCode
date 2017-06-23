package org.jason.msg.board.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import jason.common.tools.TxQueryRunner;
import org.jason.msg.board.domain.Message;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by JTrancender on 2017/3/17.
 */
public class JdbcMessageDaoImpl implements MessageDao {
    public void create(Message msg) throws SQLException {
        QueryRunner queryRunner = new TxQueryRunner();
        String sql = "insert into msg(hostId, friendId, content, time) values(?, ?, ?, ?)";
        Object []  params = {msg.getHostId(), msg.getFriendId(), msg.getContent(), msg.getTime()};

        queryRunner.update(sql, params);
    }

    public ArrayList<Message> read(String hostId) throws SQLException {
        QueryRunner queryRunner = new TxQueryRunner();
        String sql = "select hostId, friendId, content, time from msg where hostId = ?";
        Object[] params = {hostId};

        return (ArrayList<Message>) queryRunner.query(sql, new BeanListHandler<Message>(Message.class), params);
    }

    public ArrayList<Message> read(String hostId, String friendId) throws SQLException {
        QueryRunner queryRunner = new TxQueryRunner();
        String sql = "select hostId, friendId, content, time from msg where hostId = ? and friendId = ?";
        Object[] params = {hostId, friendId};

        return (ArrayList<Message>) queryRunner.query(sql, new BeanListHandler<Message>(Message.class), params);
    }
}
