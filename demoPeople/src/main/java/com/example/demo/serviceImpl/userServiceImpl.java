package com.example.demo.serviceImpl;


import com.example.demo.entity.User;
import com.example.demo.mapper.userMapper;
import com.example.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceImpl implements userService {
    @Autowired
    private userMapper userMapper;
    @Override
    public List<User> getAll(){
        return userMapper.getAll();
    }

    @Override
    public User userLogin(String username, String password) {
        return userMapper.userLogin(username,password);
    }

    @Override
    public int insUser(User user) {
        return userMapper.insUser(user);
    }

    @Override
    public User getUserByID(int id) {
        return userMapper.getUserByID(id);
    }

    @Override
    public int updateUserByID(User user) {
        return userMapper.updateUserByID(user);
    }

    @Override
    public int delUserByID(int id) {
        return userMapper.delUserByID(id);
    }

    @Override
    public User getUserByName(String username) {
        return userMapper.getUserByName(username);
    }
}
