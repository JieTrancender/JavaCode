package org.jason.user.dao;


import org.jason.user.domain.User;

/**
 * Created by JTrancender on 2017/4/12.
 */
public interface UserDao {
    void create(User user);
    User read(String identityType, String identifier);
}
