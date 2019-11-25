package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Movies;
import com.netcracker.edu.backend.entity.Orders;
import com.netcracker.edu.backend.models.Lib;
import com.netcracker.edu.backend.models.Movie;
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

    private Lib LibFilter(Orders ordersItem) {
        boolean tmpStatus = ordersItem.getStatus().equals("active");
        Movies tmpMoviesRep = movieRepository.getOneById(ordersItem.getMovieId());
        Movie tmpMovie = new Movie(tmpMoviesRep.getId(), tmpMoviesRep.getTitle(), tmpMoviesRep.getDescription(), tmpMoviesRep.getImage(), 3333,"sss");
        return new Lib(ordersItem.getId(), ordersItem.getUserId(), tmpMovie, ordersItem.getUtcEnd(), tmpStatus);
    }

    public List<Lib> getLib() {
        List<Orders> tmpOrders = ordersRepository.findAll();
        Collections.reverse(tmpOrders);
        List<Lib> resultLib = new ArrayList<Lib>();
        try{
            for (Orders tmpOrder : tmpOrders) {
                resultLib.add(this.LibFilter(tmpOrder));
            }
        }
        catch(Exception ex){
            System.out.println("LIST PARSE FALTURE");
        }
        return resultLib;
    }

    public List<Lib> getWithBorders(long start, long end) {
        List<Orders> tmpOrders = ordersRepository.findAll();
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

        Orders tmpOrders;
        Lib resultLib = new Lib();
        try{
            tmpOrders = ordersRepository.getOneById(libId);
            resultLib = this.LibFilter(tmpOrders);
            return resultLib;
        }
        catch(Exception ex){
            System.out.println("LIST PARSE FALTURE");
            return resultLib;
        }
    }
    public Lib updateLib(long orderId, Orders order) {
        Orders resultOrders;
        Lib resultLib = new Lib();
        try {
            order.setId(orderId);
            resultOrders = ordersRepository.save(order);
            resultLib = this.LibFilter(resultOrders);
            return resultLib;

        }
        catch(Exception ex){
            System.out.println("LIST PARSE FALTURE");
            return resultLib;
        }
    }

    public Lib saveMovie(Orders order) {
        Lib resultLib  = new Lib();
        Orders resultOrders;
        try {
            resultOrders = ordersRepository.save(order);
            resultLib = this.LibFilter(resultOrders);
            return resultLib;

        }
        catch(Exception ex){
            System.out.println("LIST PARSE FALTURE");
            return resultLib;
        }
    }
}
