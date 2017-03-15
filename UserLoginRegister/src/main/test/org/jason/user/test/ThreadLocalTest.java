package org.jason.user.test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JTrancender on 2017/3/15.
 */
public class ThreadLocalTest {
    @Test
    public void testThreadLocal() {
        final ThreadLocal<String> threadLocal = new ThreadLocal<String>();
//        threadLocal.set("hello");
//        String str = threadLocal.get();
//        threadLocal.remove();
//        System.out.println(str);

        new Thread() {
            public void run() {
                threadLocal.set("内部类存");
                System.out.println("内部类" + threadLocal.get());
            }
        }.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(threadLocal.get());
    }
}

//ThreadLocal通常用在一个类的成员上
//多个线程访问它时，每个线程都有自己的副本，互不干扰
//
class Person {
    private ThreadLocal<String> usernameT1 = new ThreadLocal<String>();
}

//模拟ThreadLocal类
class TL<T> {
    private Map<Thread, T> map = new HashMap<Thread, T>();

    public void set(T data) {
        map.put(Thread.currentThread(), data);
    }

    public T get() {
        return map.get(Thread.currentThread());
    }

    public void remove() {
        map.remove(Thread.currentThread());
    }
}
