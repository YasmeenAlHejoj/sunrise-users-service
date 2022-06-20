package com.yasmeenhj.poc.usersservice.users.data.repository;


import com.yasmeenhj.poc.usersservice.users.model.dto.UserDto;
import com.yasmeenhj.poc.usersservice.users.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UsersRepo {
    List<User> getAll();

    Optional<User> getById(String userId);

    User create(User user);

    boolean update(User user);

    boolean delete(String userId);

    Optional<User> findByUsername(String username);


    public void getAccountsByUserId();

}
