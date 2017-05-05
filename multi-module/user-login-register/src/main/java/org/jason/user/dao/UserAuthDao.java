package org.jason.user.dao;

import org.jason.user.domain.UserAuth;

/**
 * Created by JTrancender on 2017/4/12.
 */
public interface UserAuthDao {
    public void add(UserAuth userAuth);
    public UserAuth findByTypeAndIdentifier(String identity_type, String identifier);
    public void rememberLogin(UserAuth userAuth);
    public void forgetLogin(UserAuth userAuth);
}
