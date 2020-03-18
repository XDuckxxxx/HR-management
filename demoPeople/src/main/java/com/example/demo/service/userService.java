package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface userService {
    List<User>getAll();
    User userLogin(String username,String password);
    int insUser(User user);
    User getUserByID(int id);
    int updateUserByID(User user);
    int delUserByID(int id);
    User getUserByName(String username);
}
