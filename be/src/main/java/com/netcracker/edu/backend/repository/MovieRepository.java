package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Long>{

    @Query("SELECT e FROM Movie e order by e.id desc ")
    List<Movie> findAll();

    @Query("SELECT e FROM Movie e where e.title like %:query% OR e.description like %:query% order by e.id desc ")
    List<Movie> findAll(@Param("query") String query);

    @Query(value = "SELECT * FROM movies m order by m.m_id DESC LIMIT :start,:num", nativeQuery = true)
    List<Movie> findAll(@Param("start") long start, @Param("num") long num);

    @Query(value = "SELECT * FROM movies m WHERE m.mdb_titile LIKE %:query% OR m.mdb_descr LIKE %:query% order by m.m_id DESC LIMIT :start, :num", nativeQuery = true)
    List<Movie> findAll(@Param("start") long start, @Param("num") long num, @Param("query") String query);

    Movie getOneById(long id);

    @Query(value = "SELECT count(*) FROM movies m WHERE m.mdb_titile LIKE %:query% OR m.mdb_descr LIKE %:query% ", nativeQuery = true)
    long count(@Param("query") String query);
}
