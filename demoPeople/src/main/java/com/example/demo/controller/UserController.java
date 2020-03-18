package com.example.demo.controller;


import com.example.demo.entity.*;
import com.example.demo.service.Login_logService;
import com.example.demo.service.employeeService;
import com.example.demo.service.noticeService;
import com.example.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller

@RequestMapping("user")
public class UserController {

    @Autowired
    private userService userService;
    private employeeService employeeService;

    public UserController(com.example.demo.service.employeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Autowired
    private noticeService noticeService;
    @Autowired
    private Login_logService login_logService;
    @Autowired
    private HttpServletRequest request;

    @GetMapping("/adminIndex")
    public String getAll(HttpSession session){
        User user=(User)session.getAttribute("admin");
        if(user==null){
            return "404";
        }
        else {

            return "adminIndex";
        }
    }


    @GetMapping("/addUser")
    public String addUser(){
        return "user-add";
    }

    @PostMapping("/insUser")
    @ResponseBody
    public void insUser(User user){
        userService.insUser(user);
        System.out.println("insUser被调用！");
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/loginFail")
    public String loginFail(){return "LoginFail";}

    @GetMapping("/sessionFail")
    public String sessionFail(){return "sessionFail";}

    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id")int id ,Model model){
        User user=userService.getUserByID(id);
        model.addAttribute("user",user);
        return "user-update";
    }

    @PostMapping("/update")
    @ResponseBody
    public void updateUserByID(User user){
        userService.updateUserByID(user);
        System.out.println("更新方法被执行!");
    }

    @GetMapping("/delUser/{id}")
    public String delUserByID(@PathVariable("id")int id){
        userService.delUserByID(id);
        System.out.println("删除函数执行！");
        return "redirect:/user/list";
    }

    @GetMapping("/managerNotice")
    public String managerNotice(Model model,HttpSession session){
        User user=(User) session.getAttribute("manager");
        if(user==null){
            return "sessionFail";
        }
        else {
            List<Notice> noticeList = noticeService.getAll();
            model.addAttribute("notice", noticeList);
            return "noticeManager";
        }
    }

    @GetMapping("/delNote/{id}")
    public String delNoticeByID(@PathVariable("id")int id){
        noticeService.delNoticeByID(id);
        return "redirect:/user/managerNotice";
    }

    @GetMapping("/managerGetEmp")
    public String managerGetEmp(HttpSession session){
        User user=(User) session.getAttribute("manager");
        if(user==null){
            return "sessionFail";
        }
        else {
            return "getEmployeeManager";
        }
    }

    @GetMapping("/managerLog")
    public String managerLog(Model model,HttpSession session){
        User user=(User) session.getAttribute("manager");
        if(user==null){
            return "sessionFail";
        }
        else {
            List<ViewLog> loginList = login_logService.getAllLog();
            model.addAttribute("log", loginList);
            return "Login_logManager";
        }
    }

    @PostMapping("/userLogin")
    public String userLogin(@RequestParam("username")String username, @RequestParam("password")String password, @RequestParam("power")int power, HttpSession session){
        Date now=new Date();
        if(power==0){

            User user=userService.userLogin(username,password);
            if (user!=null&&user.getRole_name().equals("管理员")) {
                session.setAttribute("admin",user);
                login_logService.insLogWithUser(user.getUser_id(),now);
                return "redirect:/user/adminIndex";
            }
            else if(user!=null&&user.getRole_name().equals("经理")){
                session.setAttribute("manager",user);
                login_logService.insLogWithUser(user.getUser_id(),now);
                return "redirect:/user/managerNotice";
            }
            else{
                return "redirect:/user/loginFail";
            }
        }
        else {
            Employee employee=employeeService.empLogin(username,password);
            if (employee!=null){
                session.setAttribute("emp",employee);
                return "redirect:/employee/emp_getEmp";
            }
            else{
                return "redirect:/user/loginFail";
            }
        }

    }
    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }
    @GetMapping("/list")
    public String listUser(Model model){
        List<User> userList = userService.getAll();
        model.addAttribute("user", userList);
        return "userList";
    }
}
