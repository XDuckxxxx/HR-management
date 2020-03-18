package com.example.demo.mapper;


import com.example.demo.entity.Employee;
import com.example.demo.entity.ManagerEmployee;
import com.example.demo.entity.ViewEmployee;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface employeeMapper {
    @Select("select * from oa_employee")
    List<Employee> getAll();

    @Insert("insert into oa_employee(Emp_id,Dept_id,Job_id,Emp_name,Card_id,Address,Qq,Phone,Email,Sex,Birthday,Education,Speciality,Race,Remark,Create_date,EmpState) \n" +
            "values(0,#{Dept_id},#{Job_id},#{Emp_name},#{Card_id},#{Address},#{Qq},#{Phone},#{Email},#{Sex},#{Birthday},#{Education},#{Speciality},#{Race},#{Remark},#{Create_date},#{EmpState})")
    int insEmployee(Employee employee);

    @Select("select * from oa_employee where Emp_id=#{id}")
    Employee getEmployeeByID(int id);

    @Select("select emp.*,job.Job_name,job.Salary from oa_employee emp join oa_job job on emp.Job_id=job.Job_id")
    List<ViewEmployee>getAllemp();

    @Select("select emp.*,job.Job_name,job.Salary from oa_employee emp join oa_job job on emp.Job_id=job.Job_id where emp.Emp_id=#{id}")
    ViewEmployee getVEmpByID(int id);

    @Select("select emp.*,job.Job_name,dep.Dept_name from (oa_employee emp join oa_job job on emp.Job_id=job.Job_id)join oa_department dep on emp.Dept_id=dep.Dept_id")
    List<ManagerEmployee>getAllEmpByID();

    @Insert("insert into oa_employee(Emp_id,Dept_id,Job_id,Emp_name,Card_id,Address,Qq,Phone,Email,Sex,Birthday,Education,Speciality,Race,Remark,Create_date,EmpState) \n" +
            "values(#{Emp_id},#{Dept_id},#{Job_id},#{Emp_name},#{Card_id},#{Address},#{Qq},#{Phone},#{Email},#{Sex},#{Birthday},#{Education},#{Speciality},#{Race},#{Remark},#{Create_date},#{EmpState})")
    int insViewEmployee(ViewEmployee viewEmployee);

    @Update("update oa_employee set Emp_name=#{Emp_name},Card_id=#{Card_id},Address=#{Address},Qq=#{Qq},Phone=#{Phone},Email=#{Email},Sex=#{Sex},Birthday=#{Birthday},Education=#{Education},Speciality=#{Speciality},Race=#{Race},Remark=#{Remark},User_id=#{User_id} where Emp_id=#{Emp_id}")
    int updateEmployeeByID(Employee employee);

    @Delete("DELETE from oa_employee WHERE Emp_id=#{Emp_id}")
    int delEmployeeByID(int id);

    @Select("SELECT * FROM  oa_employee where Phone=#{phone} and Password=#{password}")
    Employee empLogin(@Param("phone") String phone, @Param("password") String password);

    @Select("select emp.*,job.Job_name,dep.Dept_name from (oa_employee emp join oa_job job on emp.Job_id=job.Job_id)join oa_department dep on emp.Dept_id=dep.Dept_id where emp.Emp_name=#{name}")
    ManagerEmployee getEmployeeByName(@Param("name") String name);

}
