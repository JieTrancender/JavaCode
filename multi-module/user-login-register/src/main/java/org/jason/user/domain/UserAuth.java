package org.jason.user.domain;

import org.jason.commons.CommonUtils;

/**
 * Created by JTrancender on 2017/4/12.
 */
public class UserAuth {
    private String userId;
    private String identityType;
    private String identifier;
    private String credential_digest;

    public UserAuth() {
    }

    public UserAuth(String userId, String identityType, String identifier, String credential) {
        this.userId = userId;
        this.identityType = identityType;
        this.identifier = identifier;
        this.credential_digest = CommonUtils.encoderByMd5(credential);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void addUserId() {
        this.userId = CommonUtils.uuid();
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

    public String getCredentialDigest() {
        return credential_digest;
    }

    public void setCredentialDigest(String credential) {
        this.credential_digest = CommonUtils.encoderByMd5(credential);
    }

    //notice the credential_digest has been encodered
    public void setCredential(String credential_digest) {
        this.credential_digest = credential_digest;
    }

    @Override
    public String toString() {
        return "UserAuthDao{" +
                "userId='" + userId + '\'' +
                ", identityType='" + identityType + '\'' +
                ", identifier='" + identifier + '\'' +
                ", credential_digest='" + credential_digest + '\'' +
                '}';
    }
}
