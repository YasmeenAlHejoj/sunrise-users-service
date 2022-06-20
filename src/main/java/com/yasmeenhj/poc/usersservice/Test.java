package com.yasmeenhj.poc.usersservice;

import com.yasmeenhj.poc.usersservice.users.exception.Messages;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * @author YasmeenHj
 * created on 6/15/2022 at 4:40 PM
 * @project users-service
 */
//@Component
public class Test implements CommandLineRunner {

    private final Messages messages;

    public Test(Messages messages) {
        this.messages = messages;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(messages.getMessageForLocale("message.exception", new Locale("ar")));
        System.out.println(messages.getMessageForLocale("message.exception", new Locale("en")));
    }
}
