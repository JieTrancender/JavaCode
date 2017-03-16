package org.jason.user.test;

import org.jason.user.dao.DaoFactory;
import org.jason.user.dao.UserDao;
import org.jason.user.domain.User;
import org.junit.Test;

/**
 * Created by JTrancender on 2017/3/7.
 */
public class UserDaoTest {
    @Test
    public void testFindByUserName() {
        UserDao userDao = DaoFactory.getUserDao();

        User user = userDao.findByUserName("jie-trancender.org");
        System.out.println(user);
    }

    @Test
    public void testAdd() {
        UserDao userDao = DaoFactory.getUserDao();

        User user = new User();
        user.setUserName("莫杰");
        user.setPassword("123456");
        userDao.add(user);
    }
}
