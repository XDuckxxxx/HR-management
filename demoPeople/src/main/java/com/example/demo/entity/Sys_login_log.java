package com.example.demo.entity;

import java.util.Date;

public class Sys_login_log {

    private String Id;
    private  int User_id;
    private String Ip;
    private Date Login_time;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int user_id) {
        User_id = user_id;
    }

    public String getIp() {
        return Ip;
    }

    public void setIp(String ip) {
        Ip = ip;
    }

    public Date getLogin_time() {
        return Login_time;
    }

    public void setLogin_time(Date login_time) {
        Login_time = login_time;
    }
}
