package com.pinsoft.shopapp.service;

import com.pinsoft.shopapp.entity.Role;
import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    Role getRoleByName(String name);
}
