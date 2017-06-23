import org.jason.msg.board.domain.Message;
import org.jason.msg.board.service.MessageException;
import org.jason.msg.board.service.MessageService;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by JTrancender on 2017/6/23.
 */
public class MessageServiceTest {
    @Test
    public void testGetMessages() {
        String userId = "14AC435620DF4628B172B6F6DF8553A2";
        MessageService messageService = new MessageService();
        try {
            ArrayList<Message> messageArrayList = messageService.getMessages(userId);
            for (Message message : messageArrayList) {
                System.out.println(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (MessageException e) {
            e.printStackTrace();
        }
    }
}
