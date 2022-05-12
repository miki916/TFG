package com.example.Chyl.Repositorys;

import java.util.List;

import com.example.Chyl.Entities.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>{
    
    List<Category> findAllByType(int type);

}
