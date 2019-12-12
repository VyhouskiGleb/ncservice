package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.dto.BillingResponse;
import com.netcracker.edu.backend.entity.BillingAccount;

import java.util.Optional;

public interface BillingAccountService {

    BillingAccount saveBillingAccount(BillingAccount account);
    BillingResponse updateBillingAccount(double money, long userId, BillingAccount account);
    BillingResponse getBillingAccountById(long id);
    Iterable<BillingAccount> getAllBillingAccounts();
    void deleteBillingAccount(Long id);
}
