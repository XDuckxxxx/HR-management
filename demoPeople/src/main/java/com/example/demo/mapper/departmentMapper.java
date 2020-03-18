package com.example.demo.mapper;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface departmentMapper {
    @Select("select * from oa_department")
    List<Department> getAll();
    @Insert("insert into oa_department(Dept_id,Dept_name,Remark,Is_delete) values(0,#{Dept_name},#{Remark},#{Is_delete})")
    int insDepartment(Department department);
    @Delete("DELETE from oa_department WHERE Dept_id=#{Dept_id}")
    int delDepartmentByID(int Dept_id);
    @Update("update oa_department set Dept_id=#{Dept_id},Dept_name=#{Dept_name},Remark=#{Remark},Is_delete=#{Is_delete} where Dept_id=#{Dept_id}")
    int updateDepartmentByID(Department department);
    @Select("select * from oa_department where Dept_id=#{id}")
    Department getDepartmentByID(int id);

}
