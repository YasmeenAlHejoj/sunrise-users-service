package com.yasmeenhj.poc.usersservice.users.exception;

/**
 * @author YasmeenHj
 * created on 6/15/2022 at 12:42 AM
 * @project users-service
 *
 * This class created To Group My Exception
 * to control these exceptions
 */
public class AbstractUserServiceException extends RuntimeException {
    public AbstractUserServiceException(String message) {
        super(message);
    }
}
