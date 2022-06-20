package com.yasmeenhj.poc.usersservice.users.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@Getter
@AllArgsConstructor
public class User {
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private String email;
    private String phone;
    private String userName;
    private char[] password;
    private boolean isActive;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

}
