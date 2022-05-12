package com.example.Chyl.Services;

import java.util.List;

import com.example.Chyl.Entities.*;
import com.example.Chyl.Repositorys.PersonalCatRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalCatService {
    
    @Autowired
    PersonalCatRepository repository;

    public PersonalCategory savePersonalCat(PersonalCategory category){

        return repository.save(category);

    }

    public List<PersonalCategory> getPersonalCatByType(int type){

        return repository.findAllPersonalCategoryByType(type);

    }

    public PersonalCategory getPersonalCatById(Long id){

        return repository.findOnePersonalCategoryById(id);

    }

    public Boolean existsPersonalCat(UserModel user, Website website){

        return repository.existsPersonalCategoryByUserModelAndWebsite(user, website);

    }

}
