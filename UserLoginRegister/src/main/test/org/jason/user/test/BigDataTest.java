package org.jason.user.test;

//import com.mysql.jdbc.Blob;
import org.apache.commons.io.IOUtils;
import org.jason.commons.JdbcUtils;
import org.junit.Test;

//import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialBlob;
import java.io.*;
import java.sql.*;

/**
 * Created by JTrancender on 2017/3/12.
 */
public class BigDataTest {
    @Test
    public void testSaveFile() throws SQLException, IOException {
        Connection conn = JdbcUtils.getConnection();
        String sql = "insert into tab_bin values(?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setInt(1, 1);
        pstmt.setString(2, "bigbang-if you.mp3");

        //将文件转换成byte[]
        byte[] bytes = IOUtils.toByteArray(new FileInputStream("F:/if you.mp3"));
        Blob blob = new SerialBlob(bytes);
        pstmt.setBlob(3, blob);

        pstmt.executeUpdate();
    }

    @Test
    public void testReadFile() throws SQLException, IOException {
        Connection conn = JdbcUtils.getConnection();

        String sql = "select * from tab_bin";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        ResultSet resultSet = pstmt.executeQuery();

        if (resultSet.next()) {
            Blob blob = resultSet.getBlob("data");
            InputStream inputStream = blob.getBinaryStream();
            OutputStream outputStream = new FileOutputStream("F:/test.mp3");
            IOUtils.copy(inputStream, outputStream);
        }
    }
}
