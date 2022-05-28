package com.example.Chyl.Controllers;


import com.example.Chyl.Entities.UserModel;
import com.example.Chyl.Model.UserLogin;
import com.example.Chyl.Model.Enum.RegisterEnum;
import com.example.Chyl.Security.PasswordHash;
import com.example.Chyl.Services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api/user")
public class UserController {
    
    @Autowired
    UserService service;

    @PostMapping("/register")
    public RegisterEnum saveUser(@RequestBody UserModel user){

        // Si existe el usuario con el mismo nombre de usuario devuelve un NOT_SUCCESS
        if(!service.existsUser(user.getUsername())){

            // Encriptamos la contraseña y guardamos el usuario
            user.setPasswd(PasswordHash.hash(user.getPasswd()));
            service.saveUser(user);
            return RegisterEnum.SUCCESS;
        }

        return RegisterEnum.NOT_SUCCESS;

    }

    @PostMapping("/login")
    public UserModel loginUser(@RequestBody UserLogin login){

        // Si existe el usuario con el mismo nombre de usuario devuelve un null     
        if(service.existsUser(login.getUsername())){

            // Busca el usuario en la base de datos
            UserModel user = service.getUserByUsername(login.getUsername());

            // Utiliza la función de la clase PasswordHash y compara las contraseñas, si 
            // no son iguales devuelve un null
            if(PasswordHash.decrypt(user.getPasswd(), login.getPasswd()))
                return user;

            return null;           

        }

        return null;

    }

    

}
