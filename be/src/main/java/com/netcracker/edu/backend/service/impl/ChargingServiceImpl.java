package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.BillingAccount;
import com.netcracker.edu.backend.entity.Library;
import com.netcracker.edu.backend.service.BillingAccountService;
import com.netcracker.edu.backend.service.ChargingService;
import com.netcracker.edu.backend.service.LibService;
import com.netcracker.edu.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ChargingServiceImpl implements ChargingService {
    @Value("${application.billing.rotation}")
    private String orderRotation;
    @Autowired
    LibService libService;
    @Autowired
    BillingAccountService billingAccountService;
    @Autowired
    UserService userService;

    @Scheduled(fixedDelay = 5000)
    private void startIterator() {
        Iterable<Library> tmpLibrary = libService.get("active");
        for (Library item : tmpLibrary) {
            Date tmpDate = new Date();
            System.out.println(item.getUtcEnd() - tmpDate.getTime() - 5000);
            if(tmpDate.getTime() + 5000 >= item.getUtcEnd() ) this.autoSubscriptionReplay(item);
        }

    }

    private void autoSubscriptionReplay(Library item) {
        long userId = item.getUserId();
        double movieCost = item.getMovie().getCost();
        BillingAccount tmpBilling = userService.getById(userId).getBilling();
        if(tmpBilling.getBalance() - movieCost > 0) {
            tmpBilling.setBalance(tmpBilling.getBalance() - movieCost);
            billingAccountService.saveBillingAccount(tmpBilling);
            Date tmpDate = new Date();
            System.out.println("Good money");

            item.setUtcEnd(tmpDate.getTime() + Long.parseLong(orderRotation));
        }else {
            item.setStatus("finished");
            System.out.println("Finished");
        }
        billingAccountService.saveBillingAccount(tmpBilling);
        libService.update(item.getId(), item);
    }


}
