package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.Movie;
import com.netcracker.edu.fapi.models.User;
import com.netcracker.edu.fapi.service.MovieService;
import com.netcracker.edu.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.netcracker.edu.fapi.models.Movie;
import java.util.*;

@Service("customMovieService")
public class MovieServiceImpl implements MovieService {

    @Value("${nodejs.server.url}")
    private String nodejsServerUrl;

    @Override
    public List<Movie> getAll(int end) {
        RestTemplate restTemplate = new RestTemplate();
        Movie[] usersResponse = restTemplate.getForObject(nodejsServerUrl+"api/get-movies?end="+end, Movie[].class);
        return usersResponse == null ? Collections.emptyList() : Arrays.asList(usersResponse);
    }
    @Override
    public Movie getItem(int id) {
        RestTemplate restTemplate = new RestTemplate();
        Movie usersResponse = restTemplate.getForObject(nodejsServerUrl+"api/get-movies/item?id="+id, Movie.class);
        return usersResponse == null ? new Movie() : usersResponse;
    }
    @Override
    public List<Movie> searchMovies(String query) {
        RestTemplate restTemplate = new RestTemplate();
        Movie[] usersResponse = restTemplate.getForObject(nodejsServerUrl+"api/get-movies/search?string="+query, Movie[].class);
        return usersResponse == null ? Collections.emptyList() : Arrays.asList(usersResponse);
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
