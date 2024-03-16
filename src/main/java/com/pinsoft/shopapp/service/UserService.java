package com.pinsoft.shopapp.service;

import com.pinsoft.shopapp.entity.User;
import com.pinsoft.shopapp.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public List<User> getUserByUsername(String username){
        return userRepository.findAByUsername(username);
    }

}