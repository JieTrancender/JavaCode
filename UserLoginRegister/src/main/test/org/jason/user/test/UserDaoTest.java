package org.jason.user.test;

import org.jason.user.dao.UserDao;
import org.jason.user.domain.User;
import org.junit.Test;

/**
 * Created by JTrancender on 2017/3/7.
 */
public class UserDaoTest {
    @Test
    public void testFindByUserName() {
        UserDao userDao = new UserDao();
        User user = userDao.findByUserName("王老五");
        System.out.println(user);
    }

    @Test
    public void testAdd() {
        UserDao userDao = new UserDao();

        User user = new User();
        user.setUserName("王老五");
        user.setPassword("WangWu");
        userDao.add(user);
    }
}
