package com.example.Chyl.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.Chyl.Entities.Category;
import com.example.Chyl.Entities.UserModel;
import com.example.Chyl.Entities.Website;
import com.example.Chyl.Model.PersonalCatMode;
import com.example.Chyl.Model.Enum.WebsiteEnum;
import com.example.Chyl.Services.PersonalCatService;
import com.example.Chyl.Services.WebsiteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/website")
public class WebsiteController {
    
    @Autowired
    WebsiteService service;

    @Autowired
    PersonalCatService personalService;

    @Autowired
    WebsiteService websiteService;
    
    @PostMapping("/save")
    public WebsiteEnum saveWebsite(@RequestBody Website website){
        
        if(!service.existsWebsite(website.getDomain())){

            service.saveWebsite(website);

            return WebsiteEnum.SUCCESS;

        }

        return WebsiteEnum.NOT_SUCCESS;

    }

    @GetMapping("/get/all")
    public List<Website> getAllWebsite(){

        return service.getAllWebsite();

    }

    @PostMapping("/get/favorites")
    public List<Website> getWebsitesNotFavorites(@RequestBody PersonalCatMode pCat){

        List<Website> list = service.getAllWebsite();
        List<Website> listUser = personalService.getPersonalCatByTypeAndUser(pCat.getIdtype(),pCat.getUser()).stream().map(n -> n.getWebsite()).collect(Collectors.toList());
        list.removeAll(listUser);
        return list;

    }

    @PostMapping("/get/cat")
    public List<Website> getAllWebsiteByCat(@RequestBody Category category){

        return service.getAllWebsiteByCategory(category);

    }

    @PostMapping("/get/recomendations")
    public List<Website> getRecomendations(@RequestBody UserModel user){

        List<Category> catUser = personalService.findPersonalCatByUser(user).stream().map(n -> n.getWebsite().getCategory()).collect(Collectors.toList());
        List<Website> webUser = personalService.findPersonalCatByUser(user).stream().map(n -> n.getWebsite()).collect(Collectors.toList());
        List<Website> webCat = new ArrayList<Website>();

        catUser.forEach(cat -> webCat.addAll(websiteService.getAllWebsiteByCategory(cat)));
        //webCat.removeAll(webUser);

        return webCat;
        
    }
}
