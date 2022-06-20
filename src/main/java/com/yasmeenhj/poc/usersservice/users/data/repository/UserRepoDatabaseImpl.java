package com.yasmeenhj.poc.usersservice.users.data.repository;

import com.yasmeenhj.poc.usersservice.users.data.repository.UsersRepo;
import com.yasmeenhj.poc.usersservice.users.model.entity.User;

import java.util.List;
import java.util.Optional;

class UserRepoDatabaseImpl implements UsersRepo {

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public Optional<User> getById(String userId) {
        return null;
    }

    @Override
    public User create(User user) {
        System.out.println("JPA");
        return null;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(String userId) {
        return false;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.empty();
    }


    @Override
     public void getAccountsByUserId() {

     }
 }
