package com.example.demo.serviceImpl;


import com.example.demo.entity.Sys_login_log;
import com.example.demo.entity.ViewLog;
import com.example.demo.mapper.Login_logMapper;
import com.example.demo.service.Login_logService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class Login_logServiceImpl implements Login_logService {

    @Autowired
    private Login_logMapper login_logMapper;

    @Override
    public List<Sys_login_log> getAll() {
        return login_logMapper.getAll();
    }

    @Override
    public int insLogin_log(Sys_login_log sys_login_log) {
        return login_logMapper.insLogin_log(sys_login_log);
    }

    @Override
    public Sys_login_log getLogByID(String id) {
        return login_logMapper.getLogByID(id);
    }

    @Override
    public int updateLogByID(Sys_login_log sys_login_log) {
        return login_logMapper.updateLogByID(sys_login_log);
    }

    @Override
    public int delLogByID(int id) {
        return login_logMapper.delLogByID(id);
    }

    @Override
    public int insLogWithUser(int User_id, Date now) {
        return login_logMapper.insLogWithUser(User_id,now);
    }

    @Override
    public List<ViewLog> getAllLog() {
        return login_logMapper.getAllLog();
    }

    @Override
    public List<ViewLog> getLogByEmpID(int id) {
        return login_logMapper.getLogByEmpID(id);
    }
}
