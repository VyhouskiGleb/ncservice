package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.User;
import com.netcracker.edu.fapi.models.ViewUser;

import java.util.List;

public interface UserService {

    ViewUser findViewByLogin(String login);
    User findByLogin(String login);
    List<User> findAll();
    User save(User user);
}
