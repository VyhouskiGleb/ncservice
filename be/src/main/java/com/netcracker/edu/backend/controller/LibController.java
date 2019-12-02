package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Order;
import com.netcracker.edu.backend.models.Lib;
import com.netcracker.edu.backend.service.LibService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lib")
public class LibController {
    @Autowired
     LibService libService;

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
    public Lib updateLib(@RequestBody Order order, @PathVariable(name = "id") long libId) {
        return libService.updateLib(libId, order);
    }

    @PostMapping()
    public Lib saveMovie(@RequestBody Order order) {
        return libService.saveMovie(order);
    }
}
