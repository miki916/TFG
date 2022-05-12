package com.example.Chyl.Services;

import java.util.List;

import com.example.Chyl.Entities.*;
import com.example.Chyl.Repositorys.WebsiteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebsiteService {
    
    @Autowired
    WebsiteRepository repository;


    public Website saveWebsite(Website website){

        return repository.save(website);

    }

    public List<Website> getAllWebsite(){

        return repository.findAll();

    }

    public List<Website> getAllWebsiteByCategory(Category category){

        return repository.findAllWebsiteByCategory(category);

    }

    public Website getWebsiteById(Long id){

        return repository.findOneWebsiteById(id);

    }



}
