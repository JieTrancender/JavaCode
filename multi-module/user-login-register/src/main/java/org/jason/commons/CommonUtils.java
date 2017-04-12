package org.jason.commons;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;
import java.util.UUID;

/**
 * Created by JTrancender on 2017/4/12.
 */
public class CommonUtils {
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    public static <T> T toBean(Map map, Class<T> clazz) {
        try {
            //创建指定类型的javabean对象
            //把数据封装到javabean中
            T bean = clazz.newInstance();
            BeanUtils.populate(bean, map);
            return bean;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
