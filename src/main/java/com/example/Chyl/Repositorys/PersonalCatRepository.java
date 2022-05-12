package com.example.Chyl.Repositorys;

import java.util.List;

import com.example.Chyl.Entities.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalCatRepository extends JpaRepository<PersonalCategory, Long> {
    
    List<PersonalCategory> findAllPersonalCategoryByType(int type);

    PersonalCategory findOnePersonalCategoryById(Long id);

    Boolean existsPersonalCategoryByUserModelAndWebsite(UserModel user, Website website);

}
