package com.example.Chyl.Controllers;

import java.util.List;

import com.example.Chyl.Entities.*;
import com.example.Chyl.Model.Enum.WebsiteEnum;
import com.example.Chyl.Services.WebsiteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/website")
public class WebsiteController {
    
    @Autowired
    WebsiteService service;

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

    @PostMapping("/get/cat")
    public List<Website> getAllWebsiteByCat(@RequestBody Category category){

        return service.getAllWebsiteByCategory(category);

    }
}
