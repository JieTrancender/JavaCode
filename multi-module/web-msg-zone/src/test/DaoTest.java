import org.apache.log4j.SimpleLayout;
import org.jason.msg.board.dao.DaoFactory;
import org.jason.msg.board.dao.MessageDao;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by JTrancender on 2017/6/21.
 */
public class DaoTest {
    @Test
    public void testDaoFactory() {
        MessageDao messageDao = DaoFactory.getMessageDao();
        System.out.println(messageDao);
    }

    @Test
    public void testTime() {
        Calendar cd = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT")); // 设置时区为GMT
        String str = sdf.format(cd.getTime());
        System.out.println(str);
    }
}
