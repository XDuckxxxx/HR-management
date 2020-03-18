package com.example.demo.service;

import com.example.demo.entity.Department;

import java.util.List;

public interface departmentService {
    List<Department> getAll();
    int insDepartment(Department department);
    int delDepartmentByID(int Dept_id);
    int updateDepartmentByID(Department department);
    Department getDepartmentByID(int id);
}
