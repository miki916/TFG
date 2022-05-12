package com.example.Chyl.Model;

import com.example.Chyl.Entities.UserModel;
import com.example.Chyl.Entities.Website;

public class MarkerModel {
    
    private UserModel user;
    private Website website;
    
    public UserModel getUser() {
        return user;
    }
    public void setUser(UserModel user) {
        this.user = user;
    }
    public Website getWebsite() {
        return website;
    }
    public void setWebsite(Website website) {
        this.website = website;
    }

    

}
