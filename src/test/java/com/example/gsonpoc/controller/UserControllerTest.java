package com.example.gsonpoc.controller;

import com.example.gsonpoc.model.User;
import com.example.gsonpoc.repository.UserRepository;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private Gson gson;

    @Test
    public void testCreateUser() throws Exception {
        User user = new User("Test User", "test.user@example.com");
        user.setId(1L);

        when(userRepository.save(any(User.class))).thenReturn(user);

        mockMvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(user)))
                .andExpect(status().isOk())
                .andExpect(content().json(gson.toJson(user)));
    }

    @Test
    public void testGetUser() throws Exception {
        User user1 = new User("Test User 1", "test.user1@example.com");
        user1.setId(1L);
        User user2 = new User("Test User 2", "test.user2@example.com");
        user2.setId(2L);

        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        mockMvc.perform(get("/user"))
                .andExpect(status().isOk())
                .andExpect(content().json(gson.toJson(Arrays.asList(user1, user2))));
    }

    @Test
    public void testGetUserById() throws Exception {
        User user = new User("Test User", "test.user@example.com");
        user.setId(1L);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        mockMvc.perform(get("/user/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(gson.toJson(user)));
    }
}
