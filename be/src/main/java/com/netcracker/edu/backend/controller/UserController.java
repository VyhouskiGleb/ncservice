package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.User;
import com.netcracker.edu.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login/{login}")
    public ResponseEntity<User> getUserByLogin(@PathVariable(name = "login") String login) {
        User user = userService.findByLogin(login);
        return ResponseEntity.ok(user);
    }

    @GetMapping()
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable(name = "id") long userId, @RequestBody User body) {
        return userService.updateUser(userId, body);
    }

    @PostMapping()
    public User saveUser(@RequestBody User user) {
        return userService.save(user);
    }
}
