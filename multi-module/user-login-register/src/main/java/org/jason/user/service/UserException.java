package org.jason.user.service;


/**
 * Created by JTrancender on 2017/4/21.
 */
public class UserException extends Exception {
    public UserException() {
    }

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserException(Throwable cause) {
        super(cause);
    }

    public UserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public static void raise(String message) throws UserException {
        throw new UserException(message);
    }

    public static void require(boolean condition, String message) throws UserException {
        if (!condition) {
            raise(message);
        }
    }
}
