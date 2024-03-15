package com.pinsoft.shopapp.repository;

import com.pinsoft.shopapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findAByUsername(String username);


}
