package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.Lib;
import com.netcracker.edu.fapi.models.Movie;
import com.netcracker.edu.fapi.service.LibService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service("customLibService")
public class LibServiceImpl implements LibService {

    @Value("${nodejs.server.url}")
    private String nodejsServerUrl;

    @Override
    public List<Lib> getAll() {
        System.out.print("/list/get-all");
        ArrayList<Lib> libArr = new ArrayList<Lib>();
        libArr.add(new Lib(12, new Movie(1, "Title 2", "Description 2", "image 2", 35.5, "Video 2"), 234932498, true));
        libArr.add(new Lib(13, new Movie(2, "Title 2", "Description 2", "image 2", 35.5, "Video 2"), 234932498, true));

        //todo Movie user = restTemplate.getForObject("http://localhost:8006/api/get-movies?end=10", Movie.class);
        return libArr;
    }

    public Lib getItem(long id) {
        return new Lib(id, new Movie(1, "Title 2", "Description 2", "image 2", 35.5, "Video 2"), 234932498, true);
    }
    /*@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findByLogin(String login) {
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(backendServerUrl + "/api/user/login/" + login, User.class);
        return user;
    }

    @Override
    public List<User> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        User[] usersResponse = restTemplate.getForObject(backendServerUrl + "/api/user", User[].class);
        return usersResponse == null ? Collections.emptyList() : Arrays.asList(usersResponse);
    }

    @Override
    public User save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/user", user, User.class).getBody();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
        return authorities;
    }*/

}
