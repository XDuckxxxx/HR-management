package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller

@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private employeeService employeeService;
    private departmentService departmentService;

    public EmployeeController(com.example.demo.service.departmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Autowired
    private noticeService noticeService;
    @Autowired
    private Login_logService login_logService;
    @Autowired
    private jobService jobService;
    @Autowired
    private userService userService;

    @GetMapping("/list")
    public String getAll(Model model,HttpSession session){
//        User user=(User)session.getAttribute("admin");
//        if(user==null){
//            return "sessionFail";
//        }
//        else {
            List<Employee> empList = employeeService.getAll();
            model.addAttribute("emp", empList);
            return "employeeList";
//        }
    }

    @GetMapping("/addemp")
    public String emp(Model model){
        List<Department>depList=departmentService.getAll();
        List<Job>jobList=jobService.getAll();
        model.addAttribute("dep",depList);
        model.addAttribute("job",jobList);
        return "employee-add";
    }

    @PostMapping("/postEmp")
    @ResponseBody
    public void addEmp(Employee employee){
        employeeService.insEmployee(employee);
        System.out.println("执行了插入雇员！");
    }

    @GetMapping("/update/{id}")
    public String getEmployeeByID(@PathVariable("id") int id,Model model){
        Employee employee=employeeService.getEmployeeByID(id);
        List<Department>depList=departmentService.getAll();
        List<Job>jobList=jobService.getAll();
        List<User>userList=userService.getAll();
        model.addAttribute("emp",employee);
        model.addAttribute("depGet",depList);
        model.addAttribute("jobGet",jobList);
        model.addAttribute("user",userList);
        return "employee-update";
    }

    @PostMapping("/update")
    public String updateEmployee(Employee employee){
        employeeService.updateEmployeeByID(employee);
        return "redirect:/employee/getEmp";
    }

    @GetMapping("/getEmp")
    public String getAllemp(Model model){
        List<ViewEmployee>empList=employeeService.getAllemp();
        model.addAttribute("getEmp",empList);
        return "getEmployeeIndex";
    }

    @GetMapping("/addGetEmp")
    public String addGetEmp(Model model){
        List<Department> depList=departmentService.getAll();
        model.addAttribute("getDep",depList);
        return "getEmployeeAdd";
    }

    @GetMapping("/del/{id}")
    public String delEmp(@PathVariable("id") int id){
        employeeService.delEmployeeByID(id);
        return "redirect:/employee/list";
    }

    @GetMapping("/emp_getEmp")
    public String emp_getEmp(Model model, HttpSession session){
        Employee employee=(Employee) session.getAttribute("emp");
        if(employee==null){
            return "redirect:/user/sessionFail";
        }
        else {
            int id = employee.getEmp_id();
            ViewEmployee viewEmployee = employeeService.getVEmpByID(id);
            model.addAttribute("getEmp", viewEmployee);
            return "emp_getEmp";
        }
    }

    @GetMapping("/emp_getJobSalary")
    public String emp_getJobSalary(){
        return "emp_getJobSalary";
    }

//    @GetMapping("/emp_Login_logIndex")
//    public String emp_Login_logIndex(Model model){
//        List<Sys_login_log>loginList=login_logService.getAll();
//        model.addAttribute("log",loginList);
//        return "emp_Login_logIndex";
//    }

    @GetMapping("/emp_noticeIndex")
    public String emp_noticeIndex(Model model,HttpSession session){
        Employee employee=(Employee) session.getAttribute("emp");
        if(employee==null){
            return "redirect:/user/sessionFail";
        }
        else {
            List<Notice> noticeList = noticeService.getAll();
            model.addAttribute("notice", noticeList);
            return "emp_noticeIndex";
        }
    }

    @GetMapping("/detail/{id}")
    public String detailNote(@PathVariable("id")int id,Model model){
        Notice notice=noticeService.getNoiceByID(id);
        model.addAttribute("note",notice);
        return "noticeDetail";
    }

    @GetMapping("/emp_update/{id}")
    public String updateEmp_getEmp(@PathVariable("id") int id,Model model){
        Employee employee=employeeService.getEmployeeByID(id);
        List<Department>depList=departmentService.getAll();
        model.addAttribute("emp",employee);
        model.addAttribute("depGet",depList);
        return "emp_getEmpUpdate";
    }

    @PostMapping("/queryEmp")
    public String queryEmp(@RequestParam("Emp_name")String name ,Model model){
        ManagerEmployee employee=employeeService.getEmployeeByName(name);
        model.addAttribute("emp",employee);
        return "getEmployeeManager";
    }

    @PostMapping("/emp_update")
    public String emp_update(Employee employee){
        employeeService.updateEmployeeByID(employee);
        return "redirect:/employee/emp_getEmp";
    }

    @GetMapping("/empDetail/{name}")
    public String empDetail(@PathVariable("name")String name,Model model){
        ManagerEmployee managerEmployee=employeeService.getEmployeeByName(name);
        model.addAttribute("emp",managerEmployee);
        return "employeeDetail";
    }
}
