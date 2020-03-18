package com.example.demo.controller;


import com.example.demo.entity.Employee;
import com.example.demo.entity.Sys_login_log;
import com.example.demo.entity.User;
import com.example.demo.entity.ViewLog;
import com.example.demo.service.Login_logService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller

@RequestMapping("log")
public class Login_logController {
    @Autowired
    private Login_logService login_logService;

    @GetMapping("/list")
    public String getAll(Model model, HttpSession session){
//        User user=(User)session.getAttribute("admin");
//        if(user==null){
//            return "sessionFail";
//        }
//        else {
            List<ViewLog> loginList = login_logService.getAllLog();
            model.addAttribute("log", loginList);
            return "sysLogList";
//        }
    }

    @GetMapping("/addLog")
    public String addLog(){
        return "Login_logAdd";
    }

    @PostMapping("/insLog")
    public String insLog(Sys_login_log sys_login_log){
        login_logService.insLogin_log(sys_login_log);
        return "redirect:/log/list";
    }

    @GetMapping("/update/{id}")
    public String updateLog(@PathVariable("id")String id,Model model){
        Sys_login_log sys_login_log=login_logService.getLogByID(id);
        model.addAttribute("log",sys_login_log);
        return "Login_logUpdate";
    }

    @PostMapping("/update")
    public String updateLogByID(Sys_login_log sys_login_log){
        login_logService.updateLogByID(sys_login_log);
        return "redirect:/log/list";
    }

    @GetMapping("/delLog/{id}")
    public String delLogByID(@PathVariable("id")int id){
        login_logService.delLogByID(id);
        return "redirect:/log/list";
    }

    @GetMapping("/emp_Log")
    public String emp_getEmp(Model model, HttpSession session){
        Employee employee=(Employee) session.getAttribute("emp");
        if(employee==null){
            return "redirect:/user/sessionFail";
        }
        else {
            int id = employee.getEmp_id();
            List<ViewLog> viewEmployee = login_logService.getLogByEmpID(id);
            model.addAttribute("log", viewEmployee);
            return "emp_Login_logIndex";
        }
    }
}
