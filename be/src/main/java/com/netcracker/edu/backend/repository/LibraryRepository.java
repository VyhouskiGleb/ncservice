package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Library;
import com.netcracker.edu.backend.models.Lib;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LibraryRepository extends CrudRepository<Library, Long>{

    @Query("SELECT e FROM Library e order by e.id desc ")
    List<Library> findAll();

    @Query(value ="SELECT * FROM users_orders m order by m.id  DESC LIMIT :start,:num",nativeQuery = true)
    List<Library> findAll(@Param("start") long start, @Param("num") long num);


    List<Library> findByStatus(String status);
    Library findById(long id);

    /*@Query("SELECT e FROM Library e where e.userId =userId and e.movieId= movieId")
    List<Library> getSubscription(@Param("userId") long userId, @Param("movieId") long movieId);*/
}
