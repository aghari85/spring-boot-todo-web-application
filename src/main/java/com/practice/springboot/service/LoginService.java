package com.practice.springboot.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

    public boolean validateUser(String userName, String password){
        return userName.equalsIgnoreCase("Apple") && password.equalsIgnoreCase("apple");
    }
}
