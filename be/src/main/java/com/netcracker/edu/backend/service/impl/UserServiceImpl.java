package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Users;
import com.netcracker.edu.backend.repository.UserRepository;
import com.netcracker.edu.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Users> findAll() {
        return (List<Users>) userRepository.findAll();
    }

    @Override
    public Users findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public Users save(Users user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }
}
