package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.dto.LibListResponce;
import com.netcracker.edu.fapi.dto.LibResponce;
import com.netcracker.edu.fapi.models.Lib;
import com.netcracker.edu.fapi.service.LibService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/lib")
public class LibController {
    @Autowired
    private LibService libService;
    //private UserService userService;
    // todo: @PreAuthorize("hasRole('ADMIN')")
    @PreAuthorize("hasRole('user')")
    @GetMapping()
    public LibListResponce getAllLib(){ return libService.get(); }

    /*@GetMapping("/get-item/{id}")
    public Lib getLibItem(@PathVariable int id){ return libService.get(); }*/

    @PostMapping()
    public LibResponce addSubscription(@RequestBody Lib item) {
        return libService.create(item);
    }
}
