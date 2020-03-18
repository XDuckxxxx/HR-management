package com.example.demo.controller;


import com.example.demo.entity.Department;
import com.example.demo.entity.User;
import com.example.demo.service.departmentService;
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
@RequestMapping("dep")
public class DepartmentController {

    @Autowired
    private departmentService departmentService;

    @GetMapping("/list")
    public String getAll(Model model, HttpSession session){
//        User user=(User)session.getAttribute("admin");
//        if(user==null){
//            return "sessionFail";
//        }
//        else {
            List<Department> depList = departmentService.getAll();
            model.addAttribute("dep", depList);
            return "departmentList";
//        }
    }

    @GetMapping("/depadd")
    public String dep(){
        return "department-add";
    }

    @PostMapping("/postDep")
    public String insDepartment(Department department){
        departmentService.insDepartment(department);
        return "redirect:/dep/list";
    }

    @GetMapping("/delDep/{id}")
    public String delDepartmentByID(@PathVariable("id") int Dept_id){
        departmentService.delDepartmentByID(Dept_id);
        return "redirect:/dep/list";
    }

    @GetMapping("/update/{id}")
    public String updateDepartment(@PathVariable("id")int id,Model model){
        Department department=departmentService.getDepartmentByID(id);
        model.addAttribute("dep",department);
        return "department-update";
    }

    @PostMapping("/update")
    public String updateDepartmentByID(Department department){
        departmentService.updateDepartmentByID(department);
        return "redirect:/dep/list";
    }
}
