package com.yasmeenhj.poc.usersservice.users.model.dto;

import lombok.Data;
import lombok.Getter;

/**
 * @author YasmeenHj
 * created on 6/20/2022 at 1:35 AM
 * @project users-service
 */
@Data
@Getter
public class LoginDto {
    private String username;
    private String password;
}
