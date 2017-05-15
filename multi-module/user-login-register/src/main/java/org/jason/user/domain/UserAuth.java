package org.jason.user.domain;

import org.jason.commons.CommonUtils;

/**
 * Created by JTrancender on 2017/4/12.
 */
public class UserAuth {
    private String userId;
    private String identityType;
    private String identifier;
    private String credentialDigest;
    private String rememberMeDigest;

    public UserAuth() {
    }

    public UserAuth(String userId, String identityType, String identifier, String credential, String rememberMeDigest) {
        this.userId = userId;
        this.identityType = identityType;
        this.identifier = identifier;
        this.credentialDigest = CommonUtils.encoderByMd5(credential);
        this.rememberMeDigest = rememberMeDigest;
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
        return credentialDigest;
    }

    public void setCredentialDigest(String credentialDigest) {
        this.credentialDigest = credentialDigest;
    }

    //notice the credential_digest has been encodered
    public void setCredential(String credential) {
        this.credentialDigest = CommonUtils.encoderByMd5(credential);
    }

    public String getRememberMeDigest() {
        return rememberMeDigest;
    }

    public void setRememberMeDigest(String rememberMeDigest) {
        this.rememberMeDigest = rememberMeDigest;
    }

    @Override
    public String toString() {
        return "UserAuth{" +
                "userId='" + userId + '\'' +
                ", identityType='" + identityType + '\'' +
                ", identifier='" + identifier + '\'' +
                ", credentialDigest='" + credentialDigest + '\'' +
                ", rememberMeDigest='" + rememberMeDigest + '\'' +
                '}';
    }
}
