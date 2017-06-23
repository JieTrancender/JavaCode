import org.jason.msg.board.dao.JdbcMessageDaoImpl;
import org.jason.msg.board.dao.MessageDao;
import org.jason.msg.board.domain.Message;
import org.junit.Test;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by JTrancender on 2017/6/23.
 */
public class JdbcMessageDaoTest {
//    jie-email@jie-trancender.org:88B1E2B7506744AB904F1FAE08BB620C
//    ming-email@jie-trancender.org:14AC435620DF4628B172B6F6DF8553A2
    @Test
    public void testAdd() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        String time = simpleDateFormat.format(calendar.getTime());
        Message message = new Message("3D4E02F5337345B097F59108A0B76024", "88B1E2B7506744AB904F1FAE08BB620C", "Hi, This is the second msg.", time);
        MessageDao messageDao = new JdbcMessageDaoImpl();
        try {
            messageDao.create(message);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRead() {
        MessageDao messageDao = new JdbcMessageDaoImpl();
        try {
            ArrayList<Message> messages = messageDao.read("14AC435620DF4628B172B6F6DF8553A2");
            for (Message message : messages) {
                System.out.println(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRead2() {
        MessageDao messageDao = new JdbcMessageDaoImpl();
        try {
            ArrayList<Message> messages = messageDao.read("88B1E2B7506744AB904F1FAE08BB620C", "14AC435620DF4628B172B6F6DF8553A2");
            for (Message message : messages) {
                System.out.println(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
