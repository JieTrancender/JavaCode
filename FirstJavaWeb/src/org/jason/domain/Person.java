package org.jason.domain;

/**
 * Created by JTrancender on 2017/3/3.
 * 必须为成员提供get/set方法(两者只提供一个也行)
 * 必须要有默认构造器(无参)
 * 一般对于具有get/set方法的成员变量称之为属性
 * 没有对应的成员变量，只有get/set方法也是可以的
 */
public class Person {
    private String userName;
    private int userAge;
    private String userGender;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public Person(String userName, int userAge, String userGender) {

        this.userName = userName;
        this.userAge = userAge;
        this.userGender = userGender;
    }

    public Person() {

    }

    @Override
    public String toString() {
        return "Person{" +
                "userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", userGender='" + userGender + '\'' +
                '}';
    }
}
