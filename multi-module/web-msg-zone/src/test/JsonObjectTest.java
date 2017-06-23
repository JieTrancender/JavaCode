import jason.user.domain.User;
import jason.user.service.UserService;
import org.jason.msg.board.domain.Message;
import org.jason.msg.board.service.MessageException;
import org.jason.msg.board.service.MessageService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by JTrancender on 2017/6/23.
 */
public class JsonObjectTest {
    @Test
    public void testObject() {
        MessageService messageService = new MessageService();
        UserService userService = new UserService();
        try {
            ArrayList<Message> messages = messageService.getMessages("88B1E2B7506744AB904F1FAE08BB620C");
            JSONArray jsonArray = new JSONArray(messages);
            System.out.println(jsonArray);

            ArrayList<User> users;

            JSONArray jsonArray1 = new JSONArray();
            JSONObject jsonObject1;
            for (Message message : messages) {
                jsonObject1 = new JSONObject(message);
                users = userService.read(message.getFriendId());
                for (User user : users) {
                    jsonObject1.put("name", user.getName());
                }
                jsonArray1.put(jsonObject1);
            }
            System.out.println(jsonArray1);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (MessageException e) {
            e.printStackTrace();
        }
    }
}
