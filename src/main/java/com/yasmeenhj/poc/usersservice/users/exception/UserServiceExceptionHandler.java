package com.yasmeenhj.poc.usersservice.users.exception;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author YasmeenHj
 * created on 6/15/2022 at 12:44 AM
 * @project users-service
 * This class handles exceptions at the highest level (runTimeExcAndMyCustomExc).
 * To make an exceptions came to this controller.
 */
@ControllerAdvice
public class UserServiceExceptionHandler {

    private final Messages messages;
    public UserServiceExceptionHandler(Messages messages) {
        this.messages = messages;
    }

    /**
     * For all exception with type AbstractUserServiceException
     * handel them using this function
     */
    @ExceptionHandler(AbstractUserServiceException.class)
    public ResponseEntity<Object> handle(AbstractUserServiceException ex) {
        String errorsMessage = messages.getMessageForLocale("message.exception", LocaleContextHolder.getLocale());
        ErrorsInfo errorsInfo = new ErrorsInfo(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.value(), errorsMessage);
        return new ResponseEntity<>(errorsInfo, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handle(UserNotFoundException ex) {
        String errorsMessage = messages.getMessageForLocale("message.userNotFound.exception", LocaleContextHolder.getLocale());
        ErrorsInfo errorsInfo = new ErrorsInfo(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.value(), errorsMessage);
        return new ResponseEntity<>(errorsInfo, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UsernameOrPasswordException.class)
    public ResponseEntity<Object> handle(UsernameOrPasswordException ex) {
        String errorsMessage = messages.getMessageForLocale("message.usernameOrPassword.exception", LocaleContextHolder.getLocale());
        ErrorsInfo errorsInfo = new ErrorsInfo(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.value(), errorsMessage);
        return new ResponseEntity<>(errorsInfo, HttpStatus.NOT_FOUND);
    }

    //BadRequestException
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleException() {
        String errorsMessage = messages.getMessageForLocale("message.badRequest.exception", LocaleContextHolder.getLocale());
        ErrorsInfo errorsInfo = new ErrorsInfo(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.value(), errorsMessage);
        return new ResponseEntity<>(errorsInfo, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handle(RuntimeException ex) {
        String errorsMessage = messages.getMessageForLocale("message.exception", LocaleContextHolder.getLocale());
        ErrorsInfo errorsInfo = new ErrorsInfo(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.value(), errorsMessage);
        return new ResponseEntity<>(errorsInfo, HttpStatus.BAD_REQUEST);
    }
}
