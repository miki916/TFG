package com.example.Chyl.Entities;

import java.util.Date;

import javax.persistence.*;


@Entity
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String passwd;
    private Date birthday;
    private Boolean news;
    private Date last_log;
    private Date d_creation;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPasswd() {
        return passwd;
    }
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public Boolean getNews() {
        return news;
    }
    public void setNews(Boolean news) {
        this.news = news;
    }
    public Date getLast_log() {
        return last_log;
    }
    public void setLast_log(Date last_log) {
        this.last_log = last_log;
    }
    public Date getD_creation() {
        return d_creation;
    }
    public void setD_creation(Date d_creation) {
        this.d_creation = d_creation;
    }
}
