package com.yasmeenhj.poc.usersservice.users.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

/**
 * @author YasmeenHj
 * created on 6/20/2022 at 1:54 AM
 * @project users-service
 */
@Data
@Builder
public class CreateUserDto {
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private String email;
    private String phone;
    private String userName;
    private String password;
}
