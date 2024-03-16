package com.pinsoft.shopapp.repository;

import com.pinsoft.shopapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer>{
    List<User> findAByUsername(String username);


}
