package com.example.Widget.in.service;

import com.example.Widget.in.entities.user;
import com.example.Widget.in.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService
{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public user RegisterUser(String username, String password)
    {
        user user= userRepository.findByUsername(username);
        if(user==null)
        {
            String encodedPassword = passwordEncoder.encode(password);
            return userRepository.save(new user(username, encodedPassword));
        }
        return null;
    }



    public  user LoginUser(String username, String password)
    {
        user existinguser= userRepository.findByUsername(username);
        if (existinguser != null && passwordEncoder.matches(password, existinguser.getPassword())) {
            return existinguser;
        }
        return null;
    }


}
