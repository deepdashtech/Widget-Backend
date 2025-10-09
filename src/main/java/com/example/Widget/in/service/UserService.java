package com.example.Widget.in.service;

import com.example.Widget.in.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void RegisterUSer()
    {
        System.out.println("Registering User");
    }
}
