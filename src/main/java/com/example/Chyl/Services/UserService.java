package com.example.Chyl.Services;



import com.example.Chyl.Entities.UserModel;
import com.example.Chyl.Repositorys.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    UserRepository repository;


    public Boolean existsUser(String username){

        return repository.existsByUsername(username);

    }

    public UserModel getUserByUsername(String username){

        return repository.findOneByUsername(username);

    }

    public UserModel saveUser(UserModel user){

        return repository.save(user);
    }

    public UserModel getUserById(Long id){

        return repository.findOneById(id);

    }

    


}
