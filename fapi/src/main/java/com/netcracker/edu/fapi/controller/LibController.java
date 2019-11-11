package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.Lib;
import com.netcracker.edu.fapi.service.LibService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/lib")
public class LibController {
    @Autowired
    private LibService libService;
    //private UserService userService;
    // todo: @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/get-all")
    public List<Lib> getAllLib(){ return libService.getAll(); }

    @GetMapping("/get-item/{id}")
    public Lib getLibItem(@PathVariable int id){ return libService.getItem(id); }
}
