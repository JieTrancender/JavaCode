package org.jason.user.domain;

import org.jason.commons.CommonUtils;

/**
 * Created by JTrancender on 2017/4/12.
 */
public class User {
    private String name;
    private String gender;
    private String avatar;
    private UserAuth userAuth;

    public User() {
        //this is must be
        this.userAuth = new UserAuth();
    }

    public User(String name, String gender, String avatar, UserAuth userAuth) {
        this.name = name;
        this.gender = gender;
        this.avatar = avatar;
        this.userAuth = userAuth;
    }

    public User(String name, String gender, String avatar, String identity_type, String identifier, String credent) {
        this.name = name;
        this.gender = gender;
        this.avatar = avatar;
        this.userAuth = new UserAuth();
        this.userAuth.setUserId(CommonUtils.uuid());
        this.userAuth.setIdentityType(identity_type);
        this.userAuth.setIdentifier(identifier);
        this.userAuth.setCredentialDigest(credent);
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

    public UserAuth getUserAuth() {
        return userAuth;
    }

    public void setUserAuth(UserAuth userAuth) {
        this.userAuth = userAuth;
    }

    public void setUserId(String id) {
        this.userAuth.setUserId(id);
    }

    public String getUserId() {
        return getUserAuth().getUserId();
    }

    public void setIdentityType(String identityType) {
        this.userAuth.setIdentityType(identityType);
    }

    public String getIdentityType() {
        return userAuth.getIdentityType();
    }

    public void setIdentifier(String identifier) {
        this.userAuth.setIdentifier(identifier);
    }

    public String getIdentifier() {
        return userAuth.getIdentifier();
    }

    public void setCredentialDigest(String credential) {
        this.userAuth.setCredentialDigest(credential);
    }

    public String getCredentialDigest() {
        return this.userAuth.getCredentialDigest();
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", avatar='" + avatar + '\'' +
                ", userAuth=" + userAuth +
                '}';
    }
}
