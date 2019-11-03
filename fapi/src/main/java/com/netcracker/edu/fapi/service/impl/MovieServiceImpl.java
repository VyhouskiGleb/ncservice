package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.Movie;
import com.netcracker.edu.fapi.models.User;
import com.netcracker.edu.fapi.service.MovieService;
import com.netcracker.edu.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.netcracker.edu.fapi.models.Movie;
import java.util.*;

@Service("customMovieService")
public class MovieServiceImpl implements MovieService {

    /*@Value("${backend.server.url}")
    private String backendServerUrl;*/

    @Override
    public List<Movie> getAll(int end) {
        System.out.print(end);
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie(1, "Title 1", "Description 1", "image 1", 35.5, "Video 1"));
        movies.add(new Movie(2, "Title 2", "Description 2", "image 2", 35.5, "Video 2"));
        movies.add(new Movie(3, "Title 3", "Description 3", "image 3", 35.5, "Video 3"));
        return movies;
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
