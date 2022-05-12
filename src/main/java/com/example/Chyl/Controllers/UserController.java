package com.example.Chyl.Controllers;

import com.example.Chyl.Entities.UserModel;
import com.example.Chyl.Model.UserLogin;
import com.example.Chyl.Services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {
    
    @Autowired
    UserService service;

    @PostMapping("/register")
    public UserModel saveUser(@RequestBody UserModel user){

        return service.saveUser(user);

    }

    @PostMapping("/login")
    public int loginUser(@RequestBody UserLogin login){

        if(service.existsUser(login.getUsername())){

            UserModel user = service.getUserByUsername(login.getUsername());

            if(user.getPasswd().equals(login.getPasswd()))
                return 1;

            return 0;           

        }

        return -1;

    }

}
