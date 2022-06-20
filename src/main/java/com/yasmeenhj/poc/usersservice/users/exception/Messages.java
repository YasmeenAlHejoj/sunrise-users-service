package com.yasmeenhj.poc.usersservice.users.exception;

import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.ResourceBundle;

@Component
public class Messages {

    public String getMessageForLocale(String messageKey, Locale locale) {
        return ResourceBundle.getBundle("messages", locale).getString(messageKey);
    }
}