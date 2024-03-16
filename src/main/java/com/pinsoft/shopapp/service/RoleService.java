package com.pinsoft.shopapp.service;

import com.pinsoft.shopapp.entity.Role;
import com.pinsoft.shopapp.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public List<Role> getRoleByName(String name) {
        return roleRepository.findByName(name);

    }
}
