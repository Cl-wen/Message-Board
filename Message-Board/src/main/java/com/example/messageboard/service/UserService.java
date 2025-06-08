package com.example.messageboard.service;

import com.example.messageboard.entity.User;

public interface UserService {
    User findByUsername(String username);
    User save(User user);
    boolean existsByUsername(String username);
} 