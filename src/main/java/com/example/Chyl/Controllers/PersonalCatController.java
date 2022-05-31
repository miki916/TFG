package com.example.Chyl.Controllers;

import java.util.List;

import com.example.Chyl.Entities.PersonalCategory;
import com.example.Chyl.Model.PersonalCatMode;
import com.example.Chyl.Model.Enum.PersonalEnum;
import com.example.Chyl.Services.PersonalCatService;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/personal")
public class PersonalCatController {
    
    @Autowired
    PersonalCatService service;

    @PostMapping("/save")
    public PersonalEnum saveCategory(@RequestBody PersonalCategory category){
       
        // Guardas la categoria que le pasas por el body
        if(!service.existsPersonalCat(category.getUser(), category.getWebsite())){

            try {
                
                HttpResponse<String> response = Unirest.get(category.getHomePage()).asString();

                if (response.getStatus() > 199 && response.getStatus() < 300) {

                    service.savePersonalCat(category);
                    return PersonalEnum.SUCCESS;

                } 

            } catch (UnirestException e) {
                e.printStackTrace();
            }
            

        }
        
        return PersonalEnum.NOT_SUCCESS;

    }

    @PostMapping("get")
    public List<PersonalCategory> getByType(@RequestBody PersonalCatMode pCat){
        
        return service.getPersonalCatByTypeAndUser(pCat.getIdtype(),pCat.getUser());

    }

    @PostMapping("exists")
    public Boolean existsCat(@RequestBody PersonalCategory category){

        return service.existsPersonalCat(category.getUser(), category.getWebsite());

    }

    


}
