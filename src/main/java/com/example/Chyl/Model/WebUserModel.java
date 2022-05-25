package com.example.Chyl.Model;

import com.example.Chyl.Entities.UserModel;
import com.example.Chyl.Entities.Website;

public class WebUserModel {
    
    private Website web;
    private UserModel user;

    
    public Website getWeb() {
        return web;
    }
    public void setWeb(Website web) {
        this.web = web;
    }
    public UserModel getUser() {
        return user;
    }
    public void setUser(UserModel user) {
        this.user = user;
    }

    
}
