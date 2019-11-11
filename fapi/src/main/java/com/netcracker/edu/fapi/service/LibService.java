package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.Lib;

import java.util.List;

public interface LibService {
    public List<Lib> getAll();
    public Lib getItem(long id);
}
