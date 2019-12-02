package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Order;
import com.netcracker.edu.backend.entity.User;
import com.netcracker.edu.backend.repository.UserRepository;
import com.netcracker.edu.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }
    @Override
    public User updateUser(long userId, User body) {
        try {
            User tmpUser = userRepository.getOneById(userId);
            if(body.getLogin() == null) body.setLogin(tmpUser.getLogin());
            if(body.getPassword() == null) body.setPassword(tmpUser.getPassword());
            if(body.getRole() == null) body.setRole(tmpUser.getRole());
            if(body.getOrders() == null) body.setOrders(tmpUser.getOrders());
            body.setId(userId);
            return  userRepository.save(body);
        }
        catch (Exception ex) {
            return new User();
        }
    }
}
