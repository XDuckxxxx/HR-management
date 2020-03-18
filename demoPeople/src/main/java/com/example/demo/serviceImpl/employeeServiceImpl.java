package com.example.demo.serviceImpl;


import com.example.demo.entity.Employee;
import com.example.demo.entity.ManagerEmployee;
import com.example.demo.entity.ViewEmployee;
import com.example.demo.mapper.employeeMapper;
import com.example.demo.service.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class employeeServiceImpl implements employeeService {
    @Override
    public List<Employee> getAll() {
        return employeeMapper.getAll();
    }

    @Override
    public int insEmployee(Employee employee) {
        return employeeMapper.insEmployee(employee);
    }

    @Override
    public Employee getEmployeeByID(int id) {
        return employeeMapper.getEmployeeByID(id);
    }

    @Override
    public int updateEmployeeByID(Employee employee) {
        return employeeMapper.updateEmployeeByID(employee);
    }

    @Override
    public List<ViewEmployee> getAllemp() {
        return employeeMapper.getAllemp();
    }

    //@Override
    //public int insViewEmployee(ViewEmployee viewEmployee) {
    //    return employeeMapper.insViewEmployee(viewEmployee);
    //}

    @Override
    public Employee empLogin(String phone, String password) {
        return employeeMapper.empLogin(phone,password);
    }

    @Override
    public int delEmployeeByID(int id) {
        return employeeMapper.delEmployeeByID(id);
    }

    @Override
    public ManagerEmployee getEmployeeByName(String name) {
        return employeeMapper.getEmployeeByName(name);
    }

    @Override
    public List<ManagerEmployee> getAllEmpByID() {
        return employeeMapper.getAllEmpByID();
    }

    @Override
    public ViewEmployee getVEmpByID(int id) {
        return employeeMapper.getVEmpByID(id);
    }

    @Autowired
    private employeeMapper employeeMapper;
}
