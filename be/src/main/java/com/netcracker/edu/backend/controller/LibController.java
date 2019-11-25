package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Movies;
import com.netcracker.edu.backend.entity.Orders;
import com.netcracker.edu.backend.entity.Users;
import com.netcracker.edu.backend.models.Lib;
import com.netcracker.edu.backend.service.LibService;
import com.netcracker.edu.backend.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lib")

public class LibController {
    @Autowired
    private LibService libService;

    @GetMapping()
    public List<Lib> getList() {
        return libService.getLib();
    }

    @GetMapping("/borders/{start}/{end}")
    public List<Lib> getListBordered(@PathVariable(name = "start") long start, @PathVariable(name = "end") long end ) {
        return libService.getWithBorders(start,end);
    }

    @GetMapping("/{id}")
    public Lib getById(@PathVariable(name = "id") long libId) {
        return libService.getById(libId);
    }

    @PutMapping(value = "/{id}")
    public Lib updateLib(@RequestBody Orders order, @PathVariable(name = "id") long libId) {
        return libService.updateLib(libId, order);
    }

    @PostMapping()
    public Lib saveMovie(@RequestBody Orders order) {
        return libService.saveMovie(order);
    }
}
