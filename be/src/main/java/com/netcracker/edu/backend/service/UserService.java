package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findByLogin(String login);
    User save(User user);
    User createUser(User user);
    User updateUser(long userId, User body);
    User getById(long id);
    void delete(long id);
}
