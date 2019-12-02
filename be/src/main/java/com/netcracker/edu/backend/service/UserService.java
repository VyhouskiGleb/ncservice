package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findByLogin(String login);
    User save(User user);
    User updateUser(long userId, User body);
    void delete(long id);
}
