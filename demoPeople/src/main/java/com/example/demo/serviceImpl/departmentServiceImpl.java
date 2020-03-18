package com.example.demo.serviceImpl;


import com.example.demo.entity.Department;
import com.example.demo.mapper.departmentMapper;
import com.example.demo.service.departmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class departmentServiceImpl implements departmentService {
    @Override
    public List<Department> getAll() {
        return departmentMapper.getAll();
    }

    @Override
    public int insDepartment(Department department) {
        return departmentMapper.insDepartment(department);
    }

    @Override
    public int delDepartmentByID(int Dept_id) {
        return departmentMapper.delDepartmentByID(Dept_id);
    }

    @Override
    public int updateDepartmentByID(Department department) {
        return departmentMapper.updateDepartmentByID(department);
    }

    @Override
    public Department getDepartmentByID(int id) {
        return departmentMapper.getDepartmentByID(id);
    }

    @Autowired
    private departmentMapper departmentMapper;
}
