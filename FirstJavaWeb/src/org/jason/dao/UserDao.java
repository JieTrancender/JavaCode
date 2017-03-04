package org.jason.dao;

import org.jason.domain.User;

/**
 * Created by JTrancender on 2017/3/4.
 */
public class UserDao {
    /**
     * 把数据库中的数据查询出来之后，封装到user对象中，然后返回
     * @return
     */
    public User find() {
        return new User("Jason", "JTrancender");
    }
}
