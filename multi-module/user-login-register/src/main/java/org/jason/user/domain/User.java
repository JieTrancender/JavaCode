package org.jason.user.domain;

/**
 * Created by JTrancender on 2017/4/12.
 */
public class User {
    private String name;
    private String gender;
    private String avatar;

    public User() {
    }

    public User(String name, String gender, String avatar) {
        this.name = name;
        this.gender = gender;
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
