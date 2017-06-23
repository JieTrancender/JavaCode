package jason.user.dao;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by JTrancender on 2017/4/12.
 */
public class DaoFactory {
    private static Properties properties = null;

    //加载配置文件内容到properties对象中
    static {
        try {
            InputStream inputStream = DaoFactory.class.getResourceAsStream("dao.properties");
            properties = new Properties();
            properties.load(inputStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static UserDao getUserDao() {
        String daoClassName = properties.getProperty("org.jason.user.dao.UserDao");
        return (UserDao) getDao(daoClassName);
    }

    public static UserAuthDao getUserAuthDao() {
        String daoClassName = properties.getProperty("org.jason.user.dao.UserAuthDao");
        return (UserAuthDao) getDao(daoClassName);
    }

    //通过反射创建类对象
    private static Object getDao(String daoClassName) {
        try {
            Class clazz = Class.forName(daoClassName);
            return clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
