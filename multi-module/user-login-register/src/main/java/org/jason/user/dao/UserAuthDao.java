package org.jason.user.dao;

import org.jason.user.domain.UserAuth;

/**
 * Created by JTrancender on 2017/4/12.
 */
public interface UserAuthDao {
    void add(UserAuth userAuth);
    UserAuth findByTypeAndIdentifier(String identity_type, String identifier);
    UserAuth findByUserIdAndRememberMe(String userIdDigest, String rememberMeDigest);
    void rememberLogin(UserAuth userAuth);
    void forgetLogin(UserAuth userAuth);
}
