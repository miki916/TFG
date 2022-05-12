package com.example.Chyl.Repositorys;

import com.example.Chyl.Entities.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel,Long>{
   
    Boolean existsUserModelByUsername(String username);

    UserModel findOneUserModelByUsername(String username);
    
    UserModel findOneUserModeById(Long id);
}
