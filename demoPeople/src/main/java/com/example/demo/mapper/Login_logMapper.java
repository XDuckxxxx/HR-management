package com.example.demo.mapper;


import com.example.demo.entity.Sys_login_log;
import com.example.demo.entity.ViewLog;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface Login_logMapper {

    @Select("select * from sys_login_log")
    List<Sys_login_log>getAll();

    @Insert("insert into sys_login_log(Id,User_id,Ip,Login_time) values(#{Id},#{User_id},#{Ip},#{Login_time})")
    int insLogin_log(Sys_login_log sys_login_log);

    @Select("select * from sys_login_log where Id=#{Id}")
    Sys_login_log getLogByID(String id);

    @Update("update sys_login_log set User_id=#{User_id},Ip=#{Ip},Login_time=#{Login_time} where Id=#{Id}")
    int updateLogByID(Sys_login_log sys_login_log);

    @Delete("DELETE from sys_login_log WHERE Id=#{Id}")
    int delLogByID(int id);

    @Insert("insert into sys_login_log(Id,User_id,Ip,Login_time) values(0,#{User_id},'-',#{Login_time})")
    int insLogWithUser(@Param("User_id")int User_id, @Param("Login_time")Date now);

    @Select("select log.Login_time,log.Ip,emp.Sex,user.User_name,user.Role_name,emp.Emp_name,dep.Dept_name,job.Job_name from (((sys_login_log log join oa_user user on log.User_id=user.User_id)join oa_employee emp on log.User_id=emp.User_id)join oa_department dep on emp.Dept_id=dep.Dept_id)join oa_job job on emp.Job_id=job.Job_id")
    List<ViewLog>getAllLog();

    @Select("select log.Login_time,log.Ip,emp.Sex,user.User_name,user.Role_name,emp.Emp_name,dep.Dept_name,job.Job_name from (((sys_login_log log join oa_user user on log.User_id=user.User_id)join oa_employee emp on log.User_id=emp.User_id)join oa_department dep on emp.Dept_id=dep.Dept_id)join oa_job job on emp.Job_id=job.Job_id where emp.Emp_id=#{id}")
    List<ViewLog> getLogByEmpID(int id);
}
