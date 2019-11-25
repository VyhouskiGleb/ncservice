package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Movies;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movies, Long>{

    List<Movies> findAll();

    Movies getOneById(long id);

    @Query("SELECT e FROM Movies e where e.title like %:query% OR e.description like %:query%")
    List<Movies> searchMovies(@Param("query") String query);
}
