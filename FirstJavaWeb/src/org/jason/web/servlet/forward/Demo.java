package org.jason.web.servlet.forward;

import jdk.internal.util.xml.impl.Input;
import org.junit.Test;
import sun.misc.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
/**
 * Created by JTrancender on 2017/3/1.
 */
public class Demo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        fun();
    }


    public static void fun() throws UnsupportedEncodingException {
        String name = "张三";
//        byte[] bytes = name.getBytes("utf-8");
//        System.out.println(Arrays.toString(bytes));

        String s = URLEncoder.encode(name, "UTF-8");
        System.out.println(s);

        s = URLDecoder.decode(name, "utf-8");
        System.out.println(s);
    }

    @Test
    public void func2() throws IOException {
        ClassLoader c1 = Demo.class.getClassLoader();//得到类加载器
        InputStream in = c1.getResourceAsStream("test.html");//让类加载器去类路径下查找资源
        System.out.println(IOUtils.readFully(in, 0, false));
    }

    @Test
    public void fun3() throws IOException {
        Class c = Demo.class;
        InputStream in = c.getResourceAsStream("test.html");
        System.out.println(IOUtils.readFully(in,0,false));
    }
}
