package com.example.Chyl.Controllers;

import java.util.List;

import com.example.Chyl.Entities.Category;
import com.example.Chyl.Services.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
@RequestMapping("api/category")
public class CategoryController {
    

    @Autowired
    CategoryService service;

    @PostMapping("/save")
    public Category saveCategory(@RequestBody Category category){

        return service.saveCategory(category);

    }

    @GetMapping("/get/{type}")
    public List<Category> getCategoryByType(@PathVariable(value = "type") int type){

        return service.getCategoryByType(type);

    }

}
