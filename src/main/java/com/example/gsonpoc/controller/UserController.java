package com.example.gsonpoc.controller;

import com.example.gsonpoc.model.User;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private Gson gson;

    @GetMapping("/user")
    public String getUser() {
        User user = new User("John Doe", "john.doe@example.com");
        return gson.toJson(user);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody String userJson) {
        return gson.fromJson(userJson, User.class);
    }
}
