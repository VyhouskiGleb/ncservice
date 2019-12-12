package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.dto.LibListResponce;
import com.netcracker.edu.backend.dto.LibResponce;
import com.netcracker.edu.backend.entity.BillingAccount;
import com.netcracker.edu.backend.entity.Library;
import com.netcracker.edu.backend.entity.Movie;
import com.netcracker.edu.backend.entity.User;
import com.netcracker.edu.backend.repository.LibraryRepository;
import com.netcracker.edu.backend.service.BillingAccountService;
import com.netcracker.edu.backend.service.LibService;
import com.netcracker.edu.backend.service.MoviesService;
import com.netcracker.edu.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LibServiceImpl implements LibService {
    @Value("${application.billing.rotation}")
    private String orderRotation;

    @Autowired
    private LibraryRepository libraryRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private BillingAccountService billingAccountService;
    @Autowired
    private MoviesService moviesService;

    @Override
    public List<Library> get() {
        try{
            return libraryRepository.findAll();
        }
        catch(Exception ex){
            return new ArrayList<Library>();
        }
    }

    @Override
    public LibListResponce get(long start, long perPage, long userId) {
        try{
            return new LibListResponce(true, "OK",this.getCounter(userId), libraryRepository.findAll(start, perPage, userId));
        }
        catch(Exception ex){
            return  new LibListResponce(false, "Server Exception",0, new ArrayList<Library>());
        }
    }
    @Override
    public LibListResponce get(long start, long perPage, String status, long userId) {
        try{
            return new LibListResponce(true, "OK",this.getCounter(userId, status), libraryRepository.findAll(start, perPage, status, userId));
        }
        catch(Exception ex){
            return  new LibListResponce(false, "Server Exception",0, new ArrayList<Library>());
        }
    }
    @Override
    public List<Library> get(String status) {
        try{
            return libraryRepository.findByStatus(status);
        }
        catch(Exception ex){
            return new ArrayList<Library>();
        }
    }

    @Override
    public Library get(long id) {
        try{
            return libraryRepository.findById(id);
        }
        catch(Exception ex){
            return null;
        }
    }

    @Override
    public LibResponce update(long id, Library library) {
        try {
            Library tmpLibraryItem = this.get(id);
            library.setId(id);
            if(library.getMovie().getId() == 0) {
                library.setMovie(tmpLibraryItem.getMovie());
            }
            Library tmpLib = libraryRepository.save(library);
            return new LibResponce(true, "Ok", tmpLib);
        }
        catch(Exception ex){
            return new LibResponce(false, "Server Exception", null);
        }
    }

    @Override
    public LibResponce add(Library library) {
        try {
            Date tmpDate = new Date();
            if(library.getMovie().getId() == 0) {
                return new LibResponce(false, "Movie is not provided", null);
            }
            Movie tmpMovie = moviesService.get(library.getMovie().getId());
            library.setMovie(tmpMovie);
            User user = userService.getById(library.getUserId());
            BillingAccount userBillingAccount = user.getBilling();
            if(tmpMovie.getCost() > userBillingAccount.getBalance()){
                return new LibResponce(false, "You don't have enough money", null);
            }
            userBillingAccount.setBalance(userBillingAccount.getBalance() - tmpMovie.getCost());
            library.setUtcEnd(tmpDate.getTime() + Long.parseLong(orderRotation));
            Library tmpLib = libraryRepository.save(library);
            billingAccountService.saveBillingAccount(userBillingAccount);
            return new LibResponce(true, "OK", tmpLib);
        }
        catch(Exception ex){
            return new LibResponce(false, "Server Exception", null);
        }
    }

    private long getCounter() {
        return libraryRepository.count();
    }

    private long getCounter(long userId) { return libraryRepository.countAllByUserId(userId); }
    private long getCounter(long userId, String status) { return libraryRepository.countAllByUserIdAndStatus(userId, status); }
}
