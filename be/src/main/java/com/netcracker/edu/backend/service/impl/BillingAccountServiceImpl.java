package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.dto.BillingResponse;
import com.netcracker.edu.backend.entity.BillingAccount;
import com.netcracker.edu.backend.repository.BillingAccountRepository;
import com.netcracker.edu.backend.service.BillingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BillingAccountServiceImpl implements BillingAccountService {

    private BillingAccountRepository repository;

    @Autowired
    public BillingAccountServiceImpl(BillingAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public BillingAccount saveBillingAccount(BillingAccount account) {
        return repository.save(account);
    }

    @Override
    public BillingResponse updateBillingAccount(double money, long userId, BillingAccount account) {
        try {
            BillingAccount tmpBilling = repository.getById(account.getId());
            tmpBilling.setBalance(tmpBilling.getBalance() + money);
            tmpBilling.setCredit(account.getCredit());
            return new BillingResponse(true, "User balance updated!", repository.save(tmpBilling));
        }
        catch (Exception ex) {
            return new BillingResponse(true, "Operation failed", null);
        }
    }

    @Override
    public BillingResponse getBillingAccountById(long id) {
        try {
            Optional<BillingAccount> tmpBillingAccount = repository.findById(id);
            if(!tmpBillingAccount.isPresent()) throw new Exception();
            return new BillingResponse(true, "OK", tmpBillingAccount.get());
        }
        catch (Exception ex) {
            return new BillingResponse(false, "Billing account not founded", null);
        }

    }

    @Override
    public Iterable<BillingAccount> getAllBillingAccounts() {
        return repository.findAll();
    }

    @Override
    public void deleteBillingAccount(Long id) {
        repository.deleteById(id);
    }
}
