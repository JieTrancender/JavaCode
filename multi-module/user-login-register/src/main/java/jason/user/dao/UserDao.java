package jason.user.dao;


import jason.user.domain.User;

import java.util.ArrayList;

/**
 * Created by JTrancender on 2017/4/12.
 */
public interface UserDao {
    void create(User user);
    User read(String identityType, String identifier);
    ArrayList<User> read(String userId);
    ArrayList<User> read();
}
