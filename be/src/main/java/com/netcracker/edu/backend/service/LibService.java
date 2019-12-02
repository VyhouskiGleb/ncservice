package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Order;
import com.netcracker.edu.backend.models.Lib;

import java.util.List;

public interface LibService {
    List<Lib> getLib();
    List<Lib> getWithBorders(long start, long end);
    Lib getById(long libId);
    Lib updateLib(long orderId, Order order);
    Lib saveMovie(Order order);
}
