package com.example.Chyl.Services;

import java.util.List;

import com.example.Chyl.Entities.Category;
import com.example.Chyl.Repositorys.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    
    @Autowired
    CategoryRepository repository;

    public List<Category> getCategoryByType(int type){

        return repository.findAllByType(type);

    }

    public Category saveCategory(Category category){

        return repository.save(category);

    }

}
