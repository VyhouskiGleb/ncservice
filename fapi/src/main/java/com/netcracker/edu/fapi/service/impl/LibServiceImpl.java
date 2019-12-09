package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.dto.LibListResponce;
import com.netcracker.edu.fapi.dto.LibResponce;
import com.netcracker.edu.fapi.models.Lib;
import com.netcracker.edu.fapi.models.Movie;
import com.netcracker.edu.fapi.service.LibService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service("customLibService")
public class LibServiceImpl implements LibService {

    @Value("${nodejs.server.url}")
    private String nodejsServerUrl;

    @Value("${backend.server.url}")
    private String beServerUrl;

    @Override
    public LibResponce create(Lib item) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<Lib> entity = new HttpEntity<Lib>(item);
            ResponseEntity<LibResponce> result = restTemplate.exchange(beServerUrl+"/api/lib", HttpMethod.POST, entity, LibResponce.class);
            return new LibResponce(Objects.requireNonNull(result.getBody()).status(), result.getBody().getMessage(), Objects.requireNonNull(result.getBody()).getData());
        }
        catch (Exception ex) {
            return new LibResponce(false,"Server Exception", null);
        }

    }

    @Override
    public LibResponce update(long id, Lib item) {
        try{
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<Lib> entity = new HttpEntity<Lib>(item);
            ResponseEntity<LibResponce> result = restTemplate.exchange(beServerUrl+"/api/lib/" + id, HttpMethod.POST, entity, LibResponce.class);
            return new LibResponce(Objects.requireNonNull(result.getBody()).status(), result.getBody().getMessage(), Objects.requireNonNull(result.getBody()).getData());
        }
        catch (Exception ex) {
            return new LibResponce(false , "Server Exception", null);
        }

    }

    @Override
    public LibListResponce get() {
        try{
            RestTemplate restTemplate = new RestTemplate();
            Lib[] httpResult = restTemplate.getForObject(beServerUrl + "/api/lib", Lib[].class);
            return  new LibListResponce(true, "Ok", httpResult);

        }
        catch (Exception ex) {
            return new LibListResponce(false, "Server Exception", null);
        }
    }

    @Override
    public LibListResponce get(String status) {
        try{
            RestTemplate restTemplate = new RestTemplate();
            Lib[] httpResult = restTemplate.getForObject(beServerUrl + "/api/lib/status/"+status, Lib[].class);
            return  new LibListResponce(true, "Ok", httpResult);

        }
        catch (Exception ex) {
            return new LibListResponce(false, "Server Exception", null);
        }
    }

    @Override
    public LibListResponce get(long start, long perPage) {
        try{
            RestTemplate restTemplate = new RestTemplate();
            Lib[] httpResult = restTemplate.getForObject(beServerUrl + "/api/lib/" + start + "/" + perPage, Lib[].class);
            return  new LibListResponce(true, "Ok", httpResult);

        }
        catch (Exception ex) {
            return new LibListResponce(false, "Server Exception", null);
        }
    }

    @Override
    public LibListResponce get(long start, long perPage, String status, String query) {
        try{
            RestTemplate restTemplate = new RestTemplate();
            Lib[] httpResult = restTemplate.getForObject(beServerUrl + "/api/lib/" + start + "/" + perPage+"/"+status+"/"+query, Lib[].class);
            return  new LibListResponce(true, "Ok", httpResult);

        }
        catch (Exception ex) {
            return new LibListResponce(false, "Server Exception", null);
        }
    }


}
