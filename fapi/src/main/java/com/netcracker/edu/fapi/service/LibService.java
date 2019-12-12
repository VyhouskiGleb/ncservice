package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.dto.LibListResponse;
import com.netcracker.edu.fapi.dto.LibResponse;
import com.netcracker.edu.fapi.models.Lib;

public interface LibService {
    LibListResponse get();
    LibListResponse get(String status);
    LibListResponse get(long start, long perPage, String username);
    LibListResponse get(long start, long perPage, String Status, String username);
    LibResponse create(Lib item, String username);
    LibResponse update(long id, Lib item, String username);
}
