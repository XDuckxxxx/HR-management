package com.example.demo.service;

import com.example.demo.entity.Sys_login_log;
import com.example.demo.entity.ViewLog;

import java.util.Date;
import java.util.List;

public interface Login_logService {
    List<Sys_login_log>getAll();
    int insLogin_log(Sys_login_log sys_login_log);
    Sys_login_log getLogByID(String id);
    int updateLogByID(Sys_login_log sys_login_log);
    int delLogByID(int id);
    int insLogWithUser(int User_id, Date now);
    List<ViewLog>getAllLog();
    List<ViewLog> getLogByEmpID(int id);
}
