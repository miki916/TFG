package com.example.Chyl.Controllers;

import com.example.Chyl.Entities.UserModel;
import com.example.Chyl.Model.UserLogin;
import com.example.Chyl.Model.Enum.LoginEnum;
import com.example.Chyl.Model.Enum.RegisterEnum;
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
    public RegisterEnum saveUser(@RequestBody UserModel user){

        if(!service.existsUser(user.getUsername())){

            service.saveUser(user);
            return RegisterEnum.SUCCESS;
        }

        return RegisterEnum.NOT_SUCCESS;

    }

    @PostMapping("/login")
    public LoginEnum loginUser(@RequestBody UserLogin login){

        if(service.existsUser(login.getUsername())){

            UserModel user = service.getUserByUsername(login.getUsername());

            if(user.getPasswd().equals(login.getPasswd()))
                return LoginEnum.SUCCESS;

            return LoginEnum.USER_FAIL;           

        }

        return LoginEnum.NOT_EXIST;

    }

}
