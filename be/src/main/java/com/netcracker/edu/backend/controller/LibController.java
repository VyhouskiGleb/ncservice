package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.dto.LibListResponce;
import com.netcracker.edu.backend.dto.LibResponce;
import com.netcracker.edu.backend.entity.Library;
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
    public List<Library> getList() {
        return libService.get();
    }

    @GetMapping("/{start}/{per}")
    public LibListResponce getList(@PathVariable(name = "start") long start,@PathVariable(name = "per") long perPage ) {
        return libService.get(start, perPage);
    }

    @GetMapping("/status/{status}")
    public List<Library> getActiveList(@PathVariable(name = "status") String status) {
        return libService.get(status);
    }
    
    @GetMapping("/{id}")
    public Library get(@PathVariable(name = "id") long libId) {
        return libService.get(libId);
    }

    @PutMapping("/{id}")
    public LibResponce updateSubscription(@PathVariable(name = "id") long id, @RequestBody Library library) {
        return libService.update(id, library);
    }

    @PostMapping()
    public LibResponce createSubscription(@RequestBody Library library) {
        return libService.add(library);
    }

}
