package org.jason.user.test;

/**
 * Created by JTrancender on 2017/3/15.
 */
public class Stu {
    private String username;
    private String password;
    private int age;
    private String gender;

    public Stu() {
    }

    @Override
    public String toString() {
        return "Stu{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Stu(String username, String password, int age, String gender) {

        this.username = username;
        this.password = password;
        this.age = age;
        this.gender = gender;
    }
}
