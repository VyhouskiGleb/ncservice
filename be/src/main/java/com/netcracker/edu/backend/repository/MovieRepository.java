package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Movies;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movies, Long> {

    List<Movies> findAll();

    Movies getOneById(int id);
}
