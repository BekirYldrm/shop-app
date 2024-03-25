package com.pinsoft.shopapp.service;

import com.pinsoft.shopapp.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserByUsername(String username);
    String addUser(String username, String email, String roleName, String password);
}
