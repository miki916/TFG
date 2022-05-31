package com.example.Chyl.Repositorys;

import java.util.List;

import com.example.Chyl.Entities.Category;
import com.example.Chyl.Entities.UserModel;
import com.example.Chyl.Entities.Website;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WebsiteRepository extends JpaRepository<Website, Long>{

    List<Website> findAllWebsiteByCategory(Category category);
    Website findOneWebsiteById(Long id);
    Boolean existsWebsiteByDomain(String domain);
    List<Website> findAllWebsiteByMaxAge(boolean maxAge);

    @Query(
        //value ="select Website from Website inner join PersonalCategory on PersonalCategory.website = Website where Website.category in (select distinct  Website.category from PersonalCategory inner join Website on PersonalCategory.website = Website where PersonalCategory.user = ?1) and PersonalCategory.user != ?1",
        value = "select  * from tfg.website w inner join tfg.personal_category pc on pc.website_id = w.id where w.category_id in (select distinct  w.category_id  from tfg.personal_category pc inner join tfg.website w on pc.website_id = w.id where pc.user_id = ?1) and w.id  not in (select pc2.website_id from tfg.personal_category pc2 where pc2.user_id = ?1)",
        nativeQuery = true)
    //@Query("select Website from Website")
    List<Website> findRecomendations(UserModel user);
}
