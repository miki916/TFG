package com.example.Chyl.Repositorys;

import java.util.List;

import com.example.Chyl.Entities.Marker;
import com.example.Chyl.Entities.UserModel;
import com.example.Chyl.Entities.Website;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkerRepository extends JpaRepository<Marker,Long> {
    
    List<Marker> findAllMarkerByUserAndWebsite(UserModel user, Website website);
    
    Marker findOneMarkerById(Long id);
}
