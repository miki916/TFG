package com.example.Chyl.Services;

import java.util.ArrayList;
import java.util.List;

import com.example.Chyl.Entities.Category;
import com.example.Chyl.Entities.PersonalCategory;
import com.example.Chyl.Entities.UserModel;
import com.example.Chyl.Entities.Website;
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

    public List<PersonalCategory> getPersonalCatByTypeAndUser(int type, UserModel user){

        return repository.findAllPersonalCategoryByTypeAndUser(type,user);

    }

    public PersonalCategory getPersonalCatById(Long id,UserModel user){

        return repository.findOnePersonalCategoryById(id);

    }

    public Boolean existsPersonalCat(UserModel user, Website website){

        return repository.existsPersonalCategoryByUserAndWebsite(user, website);

    }

    public List<PersonalCategory> findPersonalCatByUser(UserModel user){

        return repository.findAllPersonalCategoriesByUser(user);

    }

    public List<Website> getPersonalCatByCategory(Category category){

        List<PersonalCategory> allPerCat = repository.findAll();
        List<Website> webs = new ArrayList<Website>();
        
        
        for (PersonalCategory cat : allPerCat) {

            if(cat.getWebsite().getCategory().getId() == category.getId())
                webs.add(cat.getWebsite());
        }

        return webs;


    }

}
