package org.jason.user.test;

import org.jason.commons.JdbcUtils;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by JTrancender on 2017/3/15.
 */
public class Demo {
    @Test
    public void func() {
        Stu s = new Stu("Jason", "ShaoJie@qq.com", 21, "男");
        addStu(s);
    }
    public void addStu(Stu stu) {
        QR qr = new QR(JdbcUtils.getDataSource());
        String sql = "insert into user values(?,?,?,?)";
        Object[] params = {stu.getUsername(), stu.getPassword(), stu.getAge(), stu.getGender()};
        System.out.println(qr.update(sql, params));

//        Stu s = load("Jason");
//        System.out.println(s);

    }

    public Stu load(String userName) {
        QR qr = new QR(JdbcUtils.getDataSource());
        String sql = "select * from user where username=?";
        Object[] params = {userName};

        RsHandler<Stu> rsHandler = new RsHandler<Stu>() {
            public Stu handle(ResultSet rs) throws SQLException {
                if (!rs.next()) return null;
                Stu stu = new Stu();
                stu.setUsername(rs.getString("username"));
                stu.setPassword(rs.getString("password"));
                stu.setAge(rs.getInt("age"));
                stu.setGender(rs.getString("gender"));

                return stu;
            }
        };
        return (Stu)qr.query(sql,rsHandler,params);
    }
}
