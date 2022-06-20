package com.yasmeenhj.poc.usersservice.users.data.repository;

import com.yasmeenhj.poc.usersservice.users.model.entity.User;
import org.apache.commons.lang.ObjectUtils;

import java.util.List;
import java.util.Optional;

class UserRepoInNoSqlImpl implements UsersRepo {

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public Optional<User> getById(String id) {
        return null;
    }

    @Override
    public User create(User user) {
        System.out.println("NoSql");
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
