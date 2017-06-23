package jason.user.service;

import jason.user.dao.JdbcUserAuthDaoImpl;
import jason.user.dao.UserAuthDao;

/**
 * Created by JTrancender on 2017/4/12.
 */
public class UserAuthService {
    private UserAuthDao userAuthDao = new JdbcUserAuthDaoImpl();
}
