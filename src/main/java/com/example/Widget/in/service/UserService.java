package com.example.Widget.in.service;

import com.example.Widget.in.entities.user;
import com.example.Widget.in.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public user RegisterUser(String username, String password)
    {
        user user= userRepository.findByUsername(username);
        if(user==null)
        {
            return userRepository.save(new user(username, password));
        }
        return null;
    }

    public  user LoginUser(String username, String password)
    {
        user user= userRepository.findByUsername(username);
        if (user==null || !user.getPassword().equals(password))
        {
            return null;
        }
        return user;
    }
}
