package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Long>{

    List<Movie> findAll();

    Movie getOneById(long id);

    @Query("SELECT e FROM Movie e where e.title like %:query% OR e.description like %:query%")
    List<Movie> searchMovies(@Param("query") String query);
}
