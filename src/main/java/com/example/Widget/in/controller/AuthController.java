package com.example.Widget.in.controller;

import com.example.Widget.in.entities.user;
import com.example.Widget.in.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public ResponseEntity<String>  registerUser(@RequestBody user u)
    {
        userService.RegisterUSer();
        return  ResponseEntity.ok("Done");
    }
}
