package com.example.Widget.in.controller;

import com.example.Widget.in.dto.ApiResponse;
import com.example.Widget.in.dto.LoginRequestDto;
import com.example.Widget.in.entities.user;
import com.example.Widget.in.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Widget.in.dto.userResponse;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public ResponseEntity<ApiResponse<user>> registerUser(@RequestBody LoginRequestDto request) {
        user userResponse = userService.RegisterUser(request.getUsername(), request.getPassword());

        if (userResponse != null) {
            ApiResponse<user> res = new ApiResponse<>(true, "Successfully Registered", userResponse);
            return ResponseEntity.ok(res);
        }

        ApiResponse<user> res = new ApiResponse<>(false, "Failed To Register", null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
    }

    @PostMapping("/login")
    public  ResponseEntity<ApiResponse<user>> loginUser(@RequestBody LoginRequestDto user)
    {
        user userResponse=userService.LoginUser(user.getUsername(),user.getPassword());
        if (userResponse != null) {
            ApiResponse<user> res = new ApiResponse<>(true, "Successfully Logged", userResponse);
            return ResponseEntity.ok(res);
        }

        ApiResponse<user> res = new ApiResponse<>(false, "Failed To Login", null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
    }
}
