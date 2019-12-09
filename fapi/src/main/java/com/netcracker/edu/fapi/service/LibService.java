package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.dto.LibListResponce;
import com.netcracker.edu.fapi.dto.LibResponce;
import com.netcracker.edu.fapi.models.Lib;

import java.util.List;

public interface LibService {
    LibListResponce get();
    LibListResponce get(String status);
    LibListResponce get(long start, long perPage);
    LibListResponce get(long start, long perPage, String Status, String query);
    LibResponce create(Lib item);
    LibResponce update(long id, Lib item);
}
