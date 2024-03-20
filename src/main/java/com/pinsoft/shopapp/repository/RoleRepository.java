package com.pinsoft.shopapp.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.pinsoft.shopapp.entity.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

    Role findByName(String name);

}