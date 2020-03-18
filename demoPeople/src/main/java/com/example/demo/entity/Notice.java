package com.example.demo.entity;

import java.util.Date;

public class Notice {

    private int Notice_id;
    private String Title;
    private String Content;
    private Date Create_time;
    private int User_id;

    public int getNotice_id() {
        return Notice_id;
    }

    public void setNotice_id(int notice_id) {
        Notice_id = notice_id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Date getCreate_time() {
        return Create_time;
    }

    public void setCreate_time(Date create_time) {
        Create_time = create_time;
    }

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int user_id) {
        User_id = user_id;
    }
}
