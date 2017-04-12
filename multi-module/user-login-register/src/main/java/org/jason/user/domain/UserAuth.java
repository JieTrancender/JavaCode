package org.jason.user.domain;

/**
 * Created by JTrancender on 2017/4/12.
 */
public class UserAuth {
    private int userId;
    private String identityType;
    private String identifier;
    private String credential;

    public UserAuth() {
    }

    public UserAuth(int userId, String identityType, String identifier, String credential) {
        this.userId = userId;
        this.identityType = identityType;
        this.identifier = identifier;
        this.credential = credential;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getIdentityType() {
        return identityType;
    }

    public void setIdentityType(String identityType) {
        this.identityType = identityType;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }

    @Override
    public String toString() {
        return "UserAuthDao{" +
                "userId='" + userId + '\'' +
                ", identityType='" + identityType + '\'' +
                ", identifier='" + identifier + '\'' +
                ", credential='" + credential + '\'' +
                '}';
    }
}
