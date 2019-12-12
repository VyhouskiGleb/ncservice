package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.dto.BillingAccountResponse;
import com.netcracker.edu.fapi.models.BillingAccountViewModel;
import com.netcracker.edu.fapi.models.Movie;
import com.netcracker.edu.fapi.models.User;
import com.netcracker.edu.fapi.service.BillingAccountDataService;
import com.netcracker.edu.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BillingAccountDataServiceImpl implements BillingAccountDataService {

    @Autowired
    UserService userService;

    @Value("${backend.server.url}")
    private String beServerUrl;
    @Override
    public BillingAccountResponse updateBillingAccount(String userName, double money, BillingAccountViewModel account) {
        User tmpUser = userService.findByLogin(userName);
        long userId = tmpUser.getId();
        long baId = tmpUser.getBilling().getId();
        account.setId(baId);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<BillingAccountViewModel> entity = new HttpEntity<BillingAccountViewModel>(account);
        return restTemplate.exchange(beServerUrl+"/api/billing-accounts/"+userId+"/"+money, HttpMethod.PUT, entity, BillingAccountResponse.class).getBody();
    }
    @Override
    public BillingAccountResponse getUserBillingAccount(String userName) {
        try {
            User tmpUser = userService.findByLogin(userName);
            long baId = tmpUser.getBilling().getId();
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForObject(beServerUrl+"/api/billing-accounts/"+baId, BillingAccountResponse.class );
        }
        catch(Exception ex) {
            return null;
        }


    }
}
