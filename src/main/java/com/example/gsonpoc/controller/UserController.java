package com.example.gsonpoc.controller;

import com.example.gsonpoc.model.User;
import com.example.gsonpoc.repository.UserRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private Gson gson;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public String getUser() {
        List<User> users = userRepository.findAll();
        return gson.toJson(users);
    }

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable Long id) {
        User user = userRepository.findById(id).orElse(null);
        return gson.toJson(user);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody String userJson) {
        User user = gson.fromJson(userJson, User.class);
        return userRepository.save(user);
    }
}
