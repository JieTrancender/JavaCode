package org.jason.user.dao;

import org.jason.user.domain.User;

/**
 * Created by JTrancender on 2017/3/12.
 */
public interface UserDao {
    public void add(User user);
    public User findByUserName(String userName);
}
