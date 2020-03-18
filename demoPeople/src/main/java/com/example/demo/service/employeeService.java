package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.ManagerEmployee;
import com.example.demo.entity.ViewEmployee;

import java.util.List;

public interface employeeService {
    List<Employee> getAll();
    int insEmployee(Employee employee);
    Employee getEmployeeByID(int id);
    int updateEmployeeByID(Employee employee);
    List<ViewEmployee>getAllemp();
    //int insViewEmployee(ViewEmployee viewEmployee);
    Employee empLogin(String phone,String password);
    int delEmployeeByID(int id);
    ManagerEmployee getEmployeeByName(String name);
    List<ManagerEmployee>getAllEmpByID();
    ViewEmployee getVEmpByID(int id);
}
