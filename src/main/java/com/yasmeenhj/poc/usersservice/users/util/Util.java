package com.yasmeenhj.poc.usersservice.users.util;

import com.yasmeenhj.poc.usersservice.users.model.dto.CreateUserDto;
import com.yasmeenhj.poc.usersservice.users.model.dto.UpdateUserDto;
import com.yasmeenhj.poc.usersservice.users.model.dto.UserDto;
import com.yasmeenhj.poc.usersservice.users.model.entity.User;

import java.util.function.Function;

/**
 * @author YasmeenHj
 * created on 6/20/2022 at 1:57 AM
 * @project users-service
 */
public class Util {

    public static Function<User, UserDto> toUserDto() {
        return user -> UserDto.builder()
            .id(user.getId())
            .firstName(user.getFirstName())
            .lastName(user.getLastName())
            .birthdate(user.getBirthdate())
            .email(user.getEmail())
            .phone(user.getPhone())
            .userName(user.getUserName())
            .password(user.getPassword())
            .isActive(user.isActive())
            .createdOn(user.getCreatedOn())
            .updatedOn(user.getUpdatedOn())
            .build();
    }

    public static Function<UserDto, User> fromUserDtoToUserModel() {
        return userDto -> User.builder()
            .id(userDto.getId())
            .firstName(userDto.getFirstName())
            .lastName(userDto.getLastName())
            .birthdate(userDto.getBirthdate())
            .email(userDto.getEmail())
            .phone(userDto.getPhone())
            .userName(userDto.getUserName())
            .password(userDto.getPassword())
            .isActive(userDto.isActive())
            .createdOn(userDto.getCreatedOn())
            .updatedOn(userDto.getUpdatedOn())
            .build();
    }

    public static Function<CreateUserDto, User> fromCreateUserDtoToUserModel() {
        return userDto -> User.builder()
            .firstName(userDto.getFirstName())
            .lastName(userDto.getLastName())
            .birthdate(userDto.getBirthdate())
            .email(userDto.getEmail())
            .phone(userDto.getPhone())
            .userName(userDto.getUserName())
            .password(userDto.getPassword().toCharArray())
            .build();
    }
    public static Function<UpdateUserDto, User> fromUpdateUserDtoToUserModel() {
        return userDto -> User.builder()
            .firstName(userDto.getFirstName())
            .lastName(userDto.getLastName())
            .birthdate(userDto.getBirthdate())
            .email(userDto.getEmail())
            .phone(userDto.getPhone())
            .userName(userDto.getUserName())
            .build();
    }
}
