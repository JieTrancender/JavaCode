package org.jason.user.dao;

import org.jason.user.domain.UserAuth;

/**
 * Created by JTrancender on 2017/4/12.
 */
public interface UserAuthDao {
    void create(UserAuth userAuth);
    UserAuth read(String identityType, String identifier);
    UserAuth readByRememberMe(String userIdDigest, String rememberMeDigest);
    void updateRememberMe(String identityType, String identifier, Object object);
}
