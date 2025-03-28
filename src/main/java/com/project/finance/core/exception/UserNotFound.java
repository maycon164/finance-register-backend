package com.project.finance.core.exception;

public class UserNotFound extends NotFoundException {

    public UserNotFound() {
        super("User not found");
    }
}
