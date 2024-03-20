package com.pinsoft.shopapp.service;

import com.pinsoft.shopapp.entity.Role;
import com.pinsoft.shopapp.entity.User;
import com.pinsoft.shopapp.repository.RoleRepository;
import com.pinsoft.shopapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;


    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public List<User> getUserByUsername(String username){
        return userRepository.findAByUsername(username);
    }
    public String addUser(String username, String email, String roleName, String password){
        User user = new User();

        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        Role role = roleRepository.findByName(roleName);
        if (role == null) {
            throw new RuntimeException(roleName + " isimli rol bulunamadı");
        }
        user.setRole(role);
        userRepository.save(user);
        return "Kullanıcı ekleme başarılı";
    }
}
