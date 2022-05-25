package com.example.Chyl.Repositorys;

import java.util.List;

import com.example.Chyl.Entities.Category;
import com.example.Chyl.Entities.Website;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebsiteRepository extends JpaRepository<Website, Long>{

    List<Website> findAllWebsiteByCategory(Category category);
    Website findOneWebsiteById(Long id);
    Boolean existsWebsiteByDomain(String domain);
    
}
