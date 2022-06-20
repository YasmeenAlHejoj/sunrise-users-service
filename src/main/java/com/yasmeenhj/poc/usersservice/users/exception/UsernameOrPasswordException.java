package com.yasmeenhj.poc.usersservice.users.exception;

public class UsernameOrPasswordException extends AbstractUserServiceException {
    private final String username;

    public UsernameOrPasswordException(String username) {
        super(username);
        this.username = username;
    }
}
