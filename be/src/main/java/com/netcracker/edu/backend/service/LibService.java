package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.dto.LibListResponce;
import com.netcracker.edu.backend.dto.LibResponce;
import com.netcracker.edu.backend.entity.Library;

import java.util.List;

public interface LibService {
    List<Library> get();
    LibListResponce get(long start, long perPage, long userId);
    LibListResponce get(long start, long perPage, String status, long userId);
    List<Library> get(String status);
    Library get(long id);

    LibResponce update(long id, Library library);
    LibResponce add(Library library);
    /*List<Lib> getWithBorders(long start, long end);
    Lib getById(long libId);
    Lib updateLib(long orderId, Library order);
    Lib saveMovie(Library order);*/
}
