package com.example.Chyl.Controllers;

import java.util.List;

import com.example.Chyl.Entities.Marker;
import com.example.Chyl.Model.MarkerModel;
import com.example.Chyl.Services.MarkerService;
import com.example.Chyl.Services.UserService;
import com.example.Chyl.Services.WebsiteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/marker")
public class MarkerController {
    
    @Autowired
    MarkerService markerService;

    @Autowired
    WebsiteService webService;

    @Autowired
    UserService userService;

    @PostMapping("/save")
    public Marker saveMarker(@RequestBody Marker marker){

        return markerService.saveMarker(marker);

    }

    @PostMapping("/get")
    public List<Marker> getMarkerByUserAndWeb(@RequestBody MarkerModel userWebsite){

       
        return markerService.getAllMarkerByUserAndMarker(userWebsite.getUser(), userWebsite.getWebsite());

    }
}
