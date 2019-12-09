package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.User;
import com.netcracker.edu.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('admin')")
    @GetMapping
    public List<User> getAllUsers(){
        return userService.findAll();
    }
    @GetMapping("/login/{login}")
    public User getUserByLogin(@PathVariable String login) {
        return userService.findByLogin(login);
    }

    @PostMapping(value="/signup", produces = "application/json")
    public User saveUser(@RequestBody User user){
        return userService.save(user);
    }


}
