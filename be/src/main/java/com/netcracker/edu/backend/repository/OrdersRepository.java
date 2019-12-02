package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrdersRepository extends CrudRepository<Order, Long>{

    List<Order> findAll();
    Order getOneById(long id);

    /*@Query("SELECT e FROM Order e where e.userId =userId and e.movieId= movieId")
    List<Order> getSubscription(@Param("userId") long userId, @Param("movieId") long movieId);*/
}
