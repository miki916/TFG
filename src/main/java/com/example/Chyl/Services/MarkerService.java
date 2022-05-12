package com.example.Chyl.Services;

import java.util.List;

import com.example.Chyl.Entities.*;

import com.example.Chyl.Repositorys.MarkerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarkerService {
    
    @Autowired
    MarkerRepository repository;


    public Marker saveMarker(Marker marker){

        return repository.save(marker);

    }

    public List<Marker> getAllMarkerByUserAndMarker(UserModel user, Website website){

        return repository.findAllMarkerByUserModelAndWebsite(user, website);

    }

    public Marker getMarkerById(Long id){

        return repository.findOneMarkerById(id);

    }
    

}
