package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Movie;
import com.netcracker.edu.backend.entity.Order;
import com.netcracker.edu.backend.models.Lib;
import com.netcracker.edu.backend.repository.MovieRepository;
import com.netcracker.edu.backend.repository.OrdersRepository;
import com.netcracker.edu.backend.service.LibService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class LibServiceImpl implements LibService {
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private MovieRepository movieRepository;

    private Lib LibFilter(Order orderItem) {
        boolean tmpStatus = orderItem.getStatus().equals("active");
        Movie tmpMovieRep = movieRepository.getOneById(orderItem.getMovie().getId());
        com.netcracker.edu.backend.models.Movie tmpMovie = new com.netcracker.edu.backend.models.Movie(tmpMovieRep.getId(), tmpMovieRep.getTitle(), tmpMovieRep.getDescription(), tmpMovieRep.getImage(), 3333,"sss");
        return new Lib(orderItem.getId(), orderItem.getUserId(), tmpMovie, orderItem.getUtcEnd(), tmpStatus);
    }

    private boolean CheckSubscription(long movieId, long userId) {
        //List<Order> tmpCheckResult = ordersRepository.getSubscription(movieId, userId);
        //System.out.println(tmpCheckResult.size());

        return  false;
    }

    public List<Lib> getLib() {
        List<Order> tmpOrders = ordersRepository.findAll();
        Collections.reverse(tmpOrders);
        List<Lib> resultLib = new ArrayList<Lib>();
        try{
            for (Order tmpOrder : tmpOrders) {
                resultLib.add(this.LibFilter(tmpOrder));
            }
        }
        catch(Exception ex){
            System.out.println("LIST PARSE FALTURE");
        }
        return resultLib;
    }

    public List<Lib> getWithBorders(long start, long end) {
        List<Order> tmpOrders = ordersRepository.findAll();
        Collections.reverse(tmpOrders);

        List<Lib> resultList = new ArrayList<Lib>();

        try{
            for(long i = start; i < end; i++ ){
                resultList.add(this.LibFilter(tmpOrders.get((int) i)));
            }
        }
        catch(Exception ex){
            System.out.println("LIST PARSE FALTURE");
        }
        return resultList;
    }

    public Lib getById(long libId) {

        Order tmpOrder;
        Lib resultLib = new Lib();
        try{
            tmpOrder = ordersRepository.getOneById(libId);
            resultLib = this.LibFilter(tmpOrder);
            return resultLib;
        }
        catch(Exception ex){
            System.out.println("LIST PARSE FALTURE");
            return resultLib;
        }
    }
    public Lib updateLib(long orderId, Order order) {
        Order resultOrder;
        Lib resultLib = new Lib();
        try {
            order.setId(orderId);
            resultOrder = ordersRepository.save(order);
            resultLib = this.LibFilter(resultOrder);
            return resultLib;

        }
        catch(Exception ex){
            System.out.println("LIST PARSE FALTURE");
            return resultLib;
        }
    }

    public Lib saveMovie(Order order) {
        Lib resultLib  = new Lib();
        Order resultOrder;
        this.CheckSubscription(27, 1);
        try {
            resultOrder = ordersRepository.save(order);
            resultLib = this.LibFilter(resultOrder);
            return resultLib;

        }
        catch(Exception ex){
            System.out.println("LIST PARSE FALTURE");
            return resultLib;
        }
    }
}
