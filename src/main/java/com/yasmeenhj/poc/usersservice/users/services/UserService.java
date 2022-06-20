package com.yasmeenhj.poc.usersservice.users.services;

import com.yasmeenhj.poc.usersservice.users.data.repository.UsersRepo;
import com.yasmeenhj.poc.usersservice.users.exception.AbstractUserServiceException;
import com.yasmeenhj.poc.usersservice.users.exception.UserNotFoundException;
import com.yasmeenhj.poc.usersservice.users.exception.UsernameOrPasswordException;
import com.yasmeenhj.poc.usersservice.users.model.dto.CreateUserDto;
import com.yasmeenhj.poc.usersservice.users.model.dto.LoginDto;
import com.yasmeenhj.poc.usersservice.users.model.dto.UpdateUserDto;
import com.yasmeenhj.poc.usersservice.users.model.entity.User;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.yasmeenhj.poc.usersservice.users.util.Util.fromCreateUserDtoToUserModel;
import static com.yasmeenhj.poc.usersservice.users.util.Util.fromUpdateUserDtoToUserModel;

@Service
public class UserService {
    private final UsersRepo usersRepo;

    public UserService(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    public User create(CreateUserDto userDto) {

        try {
            User toUser = fromCreateUserDtoToUserModel().apply(userDto);
            toUser.setId(UUID.randomUUID().toString());
            toUser.setCreatedOn(LocalDateTime.now());
            toUser.setActive(false);
            char[] ar = userDto.getPassword().toCharArray();
            toUser.setPassword(ar);
            return usersRepo.create(toUser);
        } catch (Exception ex) {
            throw new AbstractUserServiceException("");
        }
    }

    public Boolean update(UpdateUserDto userDto) {
        String id = getById(userDto.getId()).getId();
        User toUser = fromUpdateUserDtoToUserModel().apply(userDto);
        toUser.setId(id);
        toUser.setUpdatedOn(LocalDateTime.now());
        return usersRepo.update(toUser);
    }

    public List<User> getAll() {
        return usersRepo.getAll();
    }

    public User getById(String userId) {
        Optional<User> user = usersRepo.getById(userId);
        return user.orElseThrow(() -> new UserNotFoundException(userId));
    }

    public boolean delete(String userId) {
        if (getById(userId) != null) {
            return usersRepo.delete(userId);
        } else {
            throw new UserNotFoundException(userId);
        }
    }

    public boolean login(LoginDto loginDto) {
        try {
            User user = findByUsername(loginDto.getUsername());
            char[] password = user.getPassword();
            String string = String.valueOf(password);
            String password1 = loginDto.getPassword();
            if (string.equals(password1)) {
                return true;
            }
            throw new UsernameOrPasswordException(user.getUserName());
        } catch (Exception e) {
            return false;
        }
    }

    public User findByUsername(String username) {
        return usersRepo.findByUsername(username)
            .orElseThrow(() -> new UsernameOrPasswordException(username));
    }
}
