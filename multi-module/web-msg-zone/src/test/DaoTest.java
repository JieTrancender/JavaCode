import org.jason.msg.board.dao.DaoFactory;
import org.jason.msg.board.dao.MessageDao;
import org.junit.Test;

/**
 * Created by JTrancender on 2017/6/21.
 */
public class DaoTest {
    @Test
    public void testDaoFactory() {
        MessageDao messageDao = DaoFactory.getMessageDao();
        System.out.println(messageDao);
    }
}
