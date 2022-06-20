package com.yasmeenhj.poc.usersservice.users.data.repository;

import com.yasmeenhj.poc.usersservice.users.exception.AbstractUserServiceException;
import com.yasmeenhj.poc.usersservice.users.model.entity.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

class UserRepoInMemoryImpl implements UsersRepo {
    List<User> list = new ArrayList<>() {{
        add(new User("id1", "first1", "last1", LocalDate.now(), "Email1", "Phone1", "username1", new char[]{'0'}, true, LocalDateTime.now(), LocalDateTime.now()));
        add(new User("id2", "first2", "last2", LocalDate.now(), "Email2", "Phone2", "username2", new char[]{'1'}, true, LocalDateTime.now(), LocalDateTime.now()));
        add(new User("id3", "first3", "last3", LocalDate.now(), "Email3", "Phone3", "username3", new char[]{'2'}, true, LocalDateTime.now(), LocalDateTime.now()));
        add(new User("id4", "first4", "last4", LocalDate.now(), "Email4", "Phone4", "username4", new char[]{'3'}, true, LocalDateTime.now(), LocalDateTime.now()));
    }};

    @Override
    public List<User> getAll() {
        return list;
    }

    @Override
    public Optional<User> getById(String id) {
        Optional<User> first = list.stream().filter(u -> u.getId().equals(id)).findFirst();
        return first;

    }

    @Override
    public User create(User user) {
        System.out.println("InMemory");
        String id = UUID.randomUUID().toString();
        user.setId(id);
        user.setCreatedOn(LocalDateTime.now());
        list.add(user);
        return user;
    }

    @Override
    public boolean update(User user) {
        try {
            User user_ = list.stream()
                .filter(u -> u.getId().equals(user.getId()))
                .findFirst().orElseThrow(() -> new AbstractUserServiceException("NotFoundException"));
            user_.setId(user.getId());
            user_.setFirstName(user.getFirstName());
            user_.setLastName(user.getLastName());
            user_.setBirthdate(user.getBirthdate());
            user_.setEmail(user.getEmail());
            user_.setPhone(user.getPhone());
            user_.setUserName(user.getUserName());
            List<User> newList = new ArrayList<>(list.stream()
                .filter(u -> !u.getId().equals(user.getId()))
                .toList());
            newList.add(user_);
            list = newList;
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(String userId) {
        try {
            List<User> users = list.stream()
                .filter(u -> !u.getId().equals(userId))
                .toList();
            list = users;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Optional<User> findByUsername(String username) {
        Optional<User> first = list.stream().filter(u -> u.getUserName().equals(username)).findFirst();
        return first;
    }


    @Override
    public void getAccountsByUserId() {

    }
}
