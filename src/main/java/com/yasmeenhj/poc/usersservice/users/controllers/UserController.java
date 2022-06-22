package com.yasmeenhj.poc.usersservice.users.controllers;

import com.yasmeenhj.poc.usersservice.users.model.dto.CreateUserDto;
import com.yasmeenhj.poc.usersservice.users.model.dto.LoginDto;
import com.yasmeenhj.poc.usersservice.users.model.dto.UpdateUserDto;
import com.yasmeenhj.poc.usersservice.users.model.entity.User;
import com.yasmeenhj.poc.usersservice.users.services.UserService;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("user.api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public EntityModel<User> create(@RequestBody CreateUserDto user) {
        User createdUser = userService.create(user);
        EntityModel<User> entityModel = EntityModel.of(createdUser)
            .add(
                linkTo(
                    methodOn(
                        UserController.class).getById(createdUser.getId()))
                    .withRel("view")
                 );
        return entityModel;
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
