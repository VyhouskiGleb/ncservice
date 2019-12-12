package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.dto.BillingAccountResponse;
import com.netcracker.edu.fapi.models.BillingAccountViewModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BillingAccountDataService {
    BillingAccountResponse updateBillingAccount(String userName, double money, BillingAccountViewModel account);
    BillingAccountResponse getUserBillingAccount(String userName);
}
