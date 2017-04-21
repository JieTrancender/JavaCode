package org.jason.user.test;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;
import org.jason.commons.JdbcUtils;
import org.junit.Test;

import javax.management.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by JTrancender on 2017/3/15.
 */
public class DbutilsTest {
//    @Test
//    public void addStu(Stu stu) {
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        try {
//            conn = JdbcUtils.getConnection();
//            String sql = "insert into user values(?,?,?,?)";
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, stu.getUsername());
//            pstmt.setString(2, stu.getPassword());
//            pstmt.setInt(3, stu.getAge());
//            pstmt.setString(4, stu.getGender());
//            pstmt.executeUpdate();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        } finally {
//        }
//    }

    @Test
    public void testQueryRunner() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "insert into user values(?,?,?,?)";
        Object[] params = {"MingEr", "MingMing", 21, "女"};

        queryRunner.update(sql, params);
    }

    @Test
    public void testSelect() throws SQLException {
        QueryRunner  queryRunner = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from user where username=?";
        Object[] params={"MingEr"};

//        ResultSetHandler<Stu> resultSetHandler = new ResultSetHandler<Stu>() {
//            public Stu handle(ResultSet resultSet) throws SQLException {
//                return null;
//            }
//        };
        //BeanHandler，它实现了ResultSetHandler
        Stu stu = queryRunner.query(sql, new BeanHandler<Stu>(Stu.class), params);
        System.out.println(stu);
    }

    @Test
    public void func() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from user";
        List<Stu> stuList = queryRunner.query(sql, new BeanListHandler<Stu>(Stu.class));

        System.out.println(stuList);
    }

    @Test
    public void func2() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from user where username=?";
        Object[] params = {"MingEr"};

        Map map = queryRunner.query(sql, new MapHandler(), params);
        System.out.println(map);
    }

    @Test
    public void  func3() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from user";

        List<Map<String, Object>> mapList = queryRunner.query(sql, new MapListHandler());

        System.out.println(mapList);
    }

    @Test
    public void func4() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select count(*) from user";

        Number obj = (Number) queryRunner.query(sql, new ScalarHandler());

        System.out.println(obj.getClass().getName());
        System.out.println(obj instanceof Long);
    }
}
