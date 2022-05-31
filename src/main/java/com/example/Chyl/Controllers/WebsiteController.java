package com.example.Chyl.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.Chyl.Entities.Category;
import com.example.Chyl.Entities.UserModel;
import com.example.Chyl.Entities.Website;
import com.example.Chyl.Model.PersonalCatMode;
import com.example.Chyl.Model.Enum.WebsiteEnum;
import com.example.Chyl.Services.CategoryService;
import com.example.Chyl.Services.PersonalCatService;
import com.example.Chyl.Services.WebsiteService;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Autowired
    CategoryService catService;

    @PostMapping("/save")
    public WebsiteEnum saveWebsite(@RequestBody Website website) {

        // Si el dominio ya está guardado devuelve un NOT_SUCESS
        if (!service.existsWebsite(website.getDomain())) {
            try {

                HttpResponse<String> response = Unirest.get(website.getDomain()).asString();

                if (response.getStatus() > 199 && response.getStatus() < 300) {

                    service.saveWebsite(website);
                    return WebsiteEnum.SUCCESS;

                }

            } catch (UnirestException e) {
                e.printStackTrace();
            }

        }

        return WebsiteEnum.NOT_SUCCESS;

    }
    // long diffInMillies = Math.abs(user.getBirthday().getTime() - new
    // Date().getTime());

    @GetMapping("/get/all")
    public List<Website> getAllWebsite(@RequestParam boolean mayor) {

        if(mayor)
            return service.getAllWebsite();
        else
            return service.getAllWebsiteByAge(mayor);

    }

    @PostMapping("/get/favorites")
    public List<Website> getWebsitesNotFavorites(@RequestBody PersonalCatMode pCat) {

        List<Website> list = service.getAllWebsite();
        List<Website> listUser = personalService.getPersonalCatByTypeAndUser(pCat.getIdtype(), pCat.getUser()).stream()
                .map(n -> n.getWebsite()).collect(Collectors.toList());
        list.removeAll(listUser);
        return list;

    }

    public List<Website> getWebsiteUserFav(Category category) {

        return personalService.getPersonalCatByCategory(category).stream().distinct().collect(Collectors.toList());

    }

    @PostMapping("/get/cat")
    public List<Website> getAllWebsiteByCat(@RequestBody Category category) {

        return service.getAllWebsiteByCategory(category);

    }

    @PostMapping("/get/recomendations")
    public List<Website> getRecomendations(@RequestBody UserModel user) {

        // // Recogemos las categorias según los gustos del usuario
        // List<Category> catUser = personalService.findPersonalCatByUser(user).stream()
        //         .map(n -> n.getWebsite().getCategory()).distinct().collect(Collectors.toList());

        // // Recogemos todas las webs que el usuario ha dado a fav
        // List<Website> webUser = personalService.findPersonalCatByUser(user).stream()
        //         .map(n -> n.getWebsite()).collect(Collectors.toList());

        // List<Website> webCat = new ArrayList<Website>();

        // // X cada categoria guardamos en la lista las
        // // webs que pertenezcan a esa categoria y que alguien haya dado a fav
        // catUser.forEach(cat -> webCat.addAll(getWebsiteUserFav(cat)));
        // webCat.removeAll(webUser);

        return service.getRecomendations(user);

    }
}
