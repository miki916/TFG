package com.example.Chyl.Controllers;

import java.util.List;

import com.example.Chyl.Entities.PersonalCategory;
import com.example.Chyl.Model.Enum.PersonalEnum;
import com.example.Chyl.Services.PersonalCatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/personal")
public class PersonalCatController {
    
    @Autowired
    PersonalCatService service;

    @PostMapping("/save")
    public PersonalEnum saveCategory(@RequestBody PersonalCategory category){

        if(service.existsPersonalCat(category.getUser(), category.getWebsite())){

            service.savePersonalCat(category);
            return PersonalEnum.SUCCESS;

        }

        return PersonalEnum.NOT_SUCCESS;

    }

    @PostMapping("get/type")
    public List<PersonalCategory> getByType(@RequestBody int type){

        return service.getPersonalCatByType(type);

    }

    


}
