package com.yasmeenhj.poc.usersservice.users.model.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author YasmeenHj
 * created on 6/20/2022 at 1:54 AM
 * @project users-service
 */
@Data
@Builder
public class UpdateUserDto {
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private String email;
    private String phone;
    private String userName;
}
