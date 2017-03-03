package org.jason.domain;

import org.apache.commons.beanutils.BeanUtils;
import org.jason.commons.CommonUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by JTrancender on 2017/3/3.
 */
public class Demo {
    @Test
    public void func() throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        String className = "org.jason.domain.Person";
        Class clazz = Class.forName(className);
        Object bean = clazz.newInstance();

        BeanUtils.setProperty(bean, "userName", "Jason");
        BeanUtils.setProperty(bean, "userAge", "21");
        BeanUtils.setProperty(bean, "userGender", "男");
        BeanUtils.setProperty(bean, "xxx", "XXX");

        String userAge = BeanUtils.getProperty(bean, "userAge");

        System.out.println(userAge);
        System.out.println(bean);
    }

    /**
     * 把map中的属性直接封装到一个bean中
     * Map: {"userName":"Jason"}
     * 将map的数据封装到一个javabean中，要求map的key域bean的属性名 相同
     */
    @Test
    public void funcSecond() throws InvocationTargetException, IllegalAccessException {
        Map<String, String> map = new HashMap<String, String>();
        map.put("userName", "Jason");
        map.put("password", "ShaoJie@qq.com");

        User user = new User();
        BeanUtils.populate(user, map);

        System.out.println(user);
    }

    @Test
    public void funcThrid() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("userName", "Jason");
        map.put("password", "ShaoJie@qq.com");

        /**
         * request.getParameter("userName")
         * request.getParameterMap()
         */

        User user = CommonUtils.toBean(map, User.class);
        System.out.println(user);
    }
}
