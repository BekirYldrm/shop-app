package com.pinsoft.shopapp.business;

import com.pinsoft.shopapp.entity.User;
import com.pinsoft.shopapp.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/getUser")
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @GetMapping("/getUserByUsername/{username}")
    public User getUser(@PathVariable String username) {

        var user = repository.findAByUsername(username);

        if (user.isEmpty()) {
            throw new RuntimeException("User not found with username: " + username);

        } else {
            return user.get();
        }
    }
}
