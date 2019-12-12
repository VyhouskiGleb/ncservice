package com.netcracker.edu.fapi.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netcracker.edu.fapi.dto.LibListResponse;
import com.netcracker.edu.fapi.dto.LibResponse;
import com.netcracker.edu.fapi.models.Lib;
import com.netcracker.edu.fapi.service.LibService;
import com.netcracker.edu.fapi.service.UserService;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service("customLibService")
public class LibServiceImpl implements LibService {
    @Autowired
    UserService userService;

    @Value("${nodejs.server.url}")
    private String nodejsServerUrl;

    @Value("${backend.server.url}")
    private String beServerUrl;

    @Override
    public LibResponse create(Lib item, String username) {
        try {
            long userId = userService.findByLogin(username).getId();
            item.setUserId(userId);
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.postForObject(beServerUrl+"/api/lib/", item, LibResponse.class);
        }
        catch (Exception ex) {
            System.out.println(ex.toString());
            return new LibResponse(false,"Server Exception", null);
        }

    }

    @Override
    public LibResponse update(long id, Lib item, String username) {
        try{
            long userId = userService.findByLogin(username).getId();
            if(item.getUserId() != userId) {
                throw new Exception();
            }
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<Lib> entity = new HttpEntity<Lib>(item);
            ResponseEntity<LibResponse> result = restTemplate.exchange(beServerUrl+"/api/lib/" + id, HttpMethod.PUT, entity, LibResponse.class);
            return new LibResponse(Objects.requireNonNull(result.getBody()).isStatus(), result.getBody().getMessage(), Objects.requireNonNull(result.getBody()).getData());
        }
        catch (Exception ex) {
            return new LibResponse(false , "Server Exception", null);
        }

    }

    @Override
    public LibListResponse get() {
        try{
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForObject(beServerUrl + "/api/lib", LibListResponse.class);

        }
        catch (Exception ex) {
            return new LibListResponse(false, "Server Exception", 0, null);
        }
    }

    @Override
    public LibListResponse get(String status) {
        try{
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForObject(beServerUrl + "/api/lib/status/"+status, LibListResponse.class);

        }
        catch (Exception ex) {
            return new LibListResponse(false, "Server Exception",0, null);
        }
    }

    @Override
    public LibListResponse get(long start, long perPage, String username) {
        try{
            long userId = userService.findByLogin(username).getId();
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForObject(beServerUrl + "/api/lib/" + start + "/" + perPage+"/"+userId, LibListResponse.class);
        }
        catch (Exception ex) {
            System.out.println(ex.toString());
            return new LibListResponse(false, ex.toString(),0, null);
        }
    }

    @Override
    public LibListResponse get(long start, long perPage, String status, String username) {
        try{
            long userId = userService.findByLogin(username).getId();
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForObject(beServerUrl + "/api/lib/" + start + "/" + perPage+"/"+status+"/"+userId, LibListResponse.class);

        }
        catch (Exception ex) {
            return new LibListResponse(false, "Server Exception",0, null);
        }
    }


}
