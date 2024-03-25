package com.pinsoft.shopapp.repository;

import com.pinsoft.shopapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findByUsername(String username);
    User findUserByUsernameAndPassword(String username, String password);
}
