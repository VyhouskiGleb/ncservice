package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Long> {

    Users findByLogin(String login);
}
