package com.yasmeenhj.poc.usersservice.users.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@Getter
@Setter
public class UserDto {
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
