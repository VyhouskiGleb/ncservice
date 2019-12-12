package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.dto.BillingAccountResponse;
import com.netcracker.edu.fapi.models.BillingAccountViewModel;
import com.netcracker.edu.fapi.models.Movie;
import com.netcracker.edu.fapi.service.BillingAccountDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ba")
public class BillingAccountDataController {

    @Autowired
    private BillingAccountDataService billingAccountDataService;

    @PreAuthorize("hasRole('user') or hasRole('admin')")
    @GetMapping("/user")
    public BillingAccountResponse getUserBillingAccount() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        return billingAccountDataService.getUserBillingAccount(userName);
    }

    @PreAuthorize("hasRole('user') or hasRole('admin')")
    @PutMapping()
    public BillingAccountResponse updateBillingAccount(@RequestBody BillingAccountViewModel billing, @RequestParam("money") double money) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        return billingAccountDataService.updateBillingAccount(userName, money, billing);
    }

}
