package com.pinsoft.shopapp.controller;

import com.pinsoft.shopapp.entity.User;
import com.pinsoft.shopapp.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(tags = "List Users", description = "Get All Users", responses = {
            @ApiResponse(description = "Success", responseCode = "200"),
            @ApiResponse(description = "Data Not Found", responseCode = "404")
    })
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @Operation(tags = "Select User", description = "Get User by Username", responses = {
            @ApiResponse(description = "Success", responseCode = "200"),
            @ApiResponse(description = "Data Not Found", responseCode = "404")
    })
    @GetMapping("/getUserByUsername/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }
}
