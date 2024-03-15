package com.pinsoft.shopapp.business;

import com.pinsoft.shopapp.entity.Role;
import com.pinsoft.shopapp.repository.RoleRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    private RoleRepository repository;

    @Operation(tags = "List Roles", description = "Get All Roles", responses = {
            @ApiResponse(description = "Success", responseCode = "200"

            ), @ApiResponse(description = "Data Not Found", responseCode = "404"

    ) })



    @GetMapping("/getRole")
    public List<Role> getAllRoles(){
        return repository.findAll();
    }

    @Operation(tags = "Select Roles", description = "Get All Roles", responses = {
            @ApiResponse(description = "Success", responseCode = "200"

            ), @ApiResponse(description = "Data Not Found", responseCode = "404"

    ) })

    @GetMapping("/getRoleByName/{name}")
    public Role getRole(@PathVariable String name){

        var role = repository.findByName(name);

        if(role.isEmpty()){
            throw new RuntimeException("Role not found with name: "+role);
        } else {
            return role.get();
        }
    }

}
