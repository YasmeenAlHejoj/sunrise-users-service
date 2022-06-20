package com.yasmeenhj.poc.usersservice.users.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * @author YasmeenHj
 * created on 6/15/2022 at 1:23 AM
 * @project users-service
 * Created to handle ExceptionMessage in Different Languages
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorsInfo {
    private int code;
    private int statusCode;
    private String errorMessageKey;
}
