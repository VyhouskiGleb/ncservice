package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Movies;
import com.netcracker.edu.backend.entity.Orders;
import org.hibernate.criterion.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrdersRepository extends CrudRepository<Orders, Long>{

    List<Orders> findAll();
    Orders getOneById(long id);
}
