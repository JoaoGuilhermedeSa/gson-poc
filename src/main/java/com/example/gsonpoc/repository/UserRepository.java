package com.example.gsonpoc.repository;

import com.example.gsonpoc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
