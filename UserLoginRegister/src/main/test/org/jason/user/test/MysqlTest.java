package org.jason.user.test;

import org.jason.commons.JdbcUtils;
import org.junit.Test;

import java.sql.*;

import static org.jason.commons.JdbcUtils.getConnection;

/**
 * Created by JTrancender on 2017/3/11.
 */
public class MysqlTest {
    @Test
    public void func() throws ClassNotFoundException, SQLException {
        /**
         * JDBC四大配置参数
         *   driverClassName com.mysql.jdbc.Driver
         *   url jdbc:mysql://localhost:3306/javadb
         *   userName
         *   password
         */
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/javadb";
        String userName = "root";
        String password = "123456";

        Class.forName(driverClassName);
        Connection conn = DriverManager.getConnection(url, userName, password);
        System.out.println(conn);

        /**
         *  对数据库操作
         */
        Statement stmt = conn.createStatement();

//        String sql = "insert into test values(3, 'Jie', '123')";
        String sql = "update test set name='MingEr' where name='jie'";
        int r = stmt.executeUpdate(sql);
        System.out.println(r);

        /**
         * 执行查询
         */
    }

    @Test
    public void testMysqlSelect() throws ClassNotFoundException, SQLException {
//        String driverClassName = "com.mysql.jdbc.Driver";
//        String url = "jdbc:mysql://localhost:3306/javadb";
//        String user = "root";
//        String password = "123456";
//
//        Class.forName(driverClassName);
//        Connection conn = DriverManager.getConnection(url, user, password);
//
//        Statement stmt = conn.createStatement();
//
//        执行Statement的查询语句
//        ResultSet rs = stmt.executeQuery("select * from test");
//
//        System.out.println(rs);
//
//        /**
//         * 解析结果集
//         *   1. 将行光标移动到第一行，可以调用next()完成，它返回一个boolean值，表示当前行是否存在
//         *
//         *
//         */
//        while (rs.next()) {
//            int db_id = rs.getInt(1);
//            String db_name = rs.getString(2);
//            String db_password = rs.getString(3);
//
//            System.out.println(db_id + ", " + db_name + ", " + db_password);
//        }
//
//        关闭资源
//        rs.close();
//        stmt.close();
//        conn.close();
    }

    @Test
    public void testJDBC() {
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/javadb";
        String name = "root";
        String password = "123456";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName(driverClassName);
            conn = DriverManager.getConnection(url, name, password);

            /**
             * createStatement函数
             *   没有参数时: 结果集不可滚动，不敏感，不可更新
             */
            stmt = conn.createStatement();

            String sql = "select * from test";
            rs = stmt.executeQuery(sql);

            int count = rs.getMetaData().getColumnCount();
            //遍历行
            while (rs.next()) {
                //遍历列
                for (int i = 1; i <= count; ++i) {
                    System.out.print(rs.getString(i));
                    if (i < count) {
                        System.out.print(", ");
                    }
                }
                System.out.println();
            }

//            while (rs.next()) {
//                int t_id = rs.getInt(1);
//                String t_name = rs.getString(2);
//                String t_password = rs.getString(3);
//
//                System.out.println(t_id + ", " + t_name + ", " + t_password);
//            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (null != rs) {
                    rs.close();
                }
                if (null != stmt) {
                    stmt.close();
                }
                if (null != conn) {
                    conn.close();
                }
            } catch (SQLException e) {
                //无内容
            }
        }
    }

    @Test
    public void testSafeSql(/*String username, String password*/) {
//        String username = "a' or 'a' = 'a";
//        String password = "a' or 'a' = 'a";
        String username = "zhangsan";
        String password = "123";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb?"
                    + "userServerPrepStmts=true&cachePrepStmts=true&rewriteBatchedStatements=true&useSSL=false",
                    "root", "123456");

            /*stmt = conn.createStatement();

            String sql = "select * from user where username = '" + username + "' and password = '" + password + "'";
            System.out.println(sql);

            rs = stmt.executeQuery(sql);

            System.out.println(rs.next());*/

            /**
             * 一、得到PreparedStatement
             * 1. 给出sql模板: 所有的参数使用？来代替
             * 2. 调用Connection方法，得到PreparedStatement
             */
            String sql = "select * from user where username=? and password=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            /**
             * 二、为参数赋值
             */
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            /**
             * 三、调用executeUpdate或者executeQuery方法
             */
            rs = pstmt.executeQuery();;  //调用查询方法，向数据库发送查询语句
            System.out.println(rs.next());

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {}
        }
    }

    @Test
    public void testConnection() {
        Connection conn = null;

        try {
            conn = getConnection();
            System.out.println(conn);
            conn = getConnection();
            System.out.println(conn);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {}
            }
        }
    }

    @Test
    public void testBatching() throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        String sql = "insert into user values(?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        for (int i = 0; i < 1000; ++i) {
            pstmt.setString(1, "stu_" + i);
            pstmt.setString(2, "mima");
            pstmt.setInt(3, i);
            pstmt.setString(4, i % 2 == 0 ? "男" : "女");

            pstmt.addBatch();  //添加批处理
        }
        long start = System.currentTimeMillis();
        pstmt.executeBatch();  //执行批处理
        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}
