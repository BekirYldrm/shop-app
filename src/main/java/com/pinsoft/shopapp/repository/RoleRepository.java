package com.pinsoft.shopapp.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.pinsoft.shopapp.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

    List<Role> findByName(String name);
}