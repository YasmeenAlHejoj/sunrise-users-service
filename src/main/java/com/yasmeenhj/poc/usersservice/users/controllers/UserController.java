package com.yasmeenhj.poc.usersservice.users.controllers;

import com.yasmeenhj.poc.usersservice.users.model.dto.CreateUserDto;
import com.yasmeenhj.poc.usersservice.users.model.dto.LoginDto;
import com.yasmeenhj.poc.usersservice.users.model.dto.UpdateUserDto;
import com.yasmeenhj.poc.usersservice.users.model.dto.UserDto;
import com.yasmeenhj.poc.usersservice.users.model.entity.User;
import com.yasmeenhj.poc.usersservice.users.services.UserService;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;

import javax.ws.rs.HeaderParam;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

@RestController
@RequestMapping("user.api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User create(@RequestBody CreateUserDto user) {
        return userService.create(user);
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("{userId}")
    public User getById(@PathVariable("userId") String userId) {
        return userService.getById(userId);
    }


    @PutMapping
    public Boolean update(@RequestBody UpdateUserDto user) {
        return userService.update(user);
    }

    @DeleteMapping("{userId}")
    public boolean delete(@PathVariable String userId) {
        return userService.delete(userId);

    }

    @GetMapping("login")
    public Boolean login(@RequestBody LoginDto loginDto) {
        return userService.login(loginDto);
    }


}
