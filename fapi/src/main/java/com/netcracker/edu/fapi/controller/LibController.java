package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.dto.LibListResponse;
import com.netcracker.edu.fapi.dto.LibResponse;
import com.netcracker.edu.fapi.models.Lib;
import com.netcracker.edu.fapi.service.LibService;
import com.netcracker.edu.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/lib")
public class LibController {
    @Autowired
    private LibService libService;
    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('admin')")
    @GetMapping()
    public LibListResponse getAllLib(){ return libService.get(); }

    @PreAuthorize("hasRole('user') or hasRole('admin')")
    @GetMapping("/borders")
    public LibListResponse getLib(@RequestParam("start") long start, @RequestParam("per") long per ){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        return libService.get(start, per, userName);
    }
    @PreAuthorize("hasRole('user') or hasRole('admin')")
    @GetMapping("/user-lib")
    public LibListResponse getUserLib(@RequestParam("start") long start, @RequestParam("per") long per ){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        return libService.get(start, per,"active", userName);
    }

    @PreAuthorize("hasRole('user') or hasRole('admin')")
    @PostMapping()
    public LibResponse addSubscription(@RequestBody Lib item) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        return libService.create(item, userName);
    }
    @PreAuthorize("hasRole('user') or hasRole('admin')")
    @PutMapping("/{id}")
    public LibResponse addSubscription(@PathVariable(name = "id") long id, @RequestBody Lib item) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        return libService.update(id ,item, userName);
    }
}
