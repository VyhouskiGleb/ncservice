package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.dto.BillingResponse;
import com.netcracker.edu.backend.entity.BillingAccount;
import com.netcracker.edu.backend.service.BillingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/billing-accounts")
public class BillingAccountController {

    private BillingAccountService billingAccountService;

    @Autowired
    public BillingAccountController(BillingAccountService billingAccountService) {
        this.billingAccountService = billingAccountService;
    }

    @GetMapping("/{id}")
    public BillingResponse getBillingAccountById(@PathVariable(name = "id") long id) {
        return billingAccountService.getBillingAccountById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<BillingAccount> getAllBillingAcounts() {
        return billingAccountService.getAllBillingAccounts();
    }

    @RequestMapping(method = RequestMethod.POST)
    public BillingAccount saveBillingAccount(@RequestBody BillingAccount account) {
        return billingAccountService.saveBillingAccount(account);
    }

    @PutMapping("/{userId}/{money}")
    public BillingResponse updateBillingAccount(@PathVariable(name = "userId") long userId, @PathVariable(name = "money") double money, @RequestBody BillingAccount account) {
        return billingAccountService.updateBillingAccount(money, userId, account);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteBillingAccount(@PathVariable(name = "id") Long id) {
        billingAccountService.deleteBillingAccount(id);
    }

}
