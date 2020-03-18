package com.example.demo.mapper;

import com.example.demo.entity.Job;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface jobMapper {
    @Select("select * from oa_job")
    List<Job> getAll();
    @Insert("insert into oa_job(Job_id,Job_name,remark,Salary) values(0,#{Job_name},#{remark},#{Salary})")
    int insJob(Job job);
    @Select("select * from oa_job where Job_id=#{id}")
    Job getJobByID(int id);
    @Update("update oa_job set Job_name=#{Job_name},remark=#{remark},Salary=#{Salary} where Job_id=#{Job_id}")
    int updateJobByID(Job job);
    @Delete("DELETE from oa_job WHERE Job_id=#{Job_id}")
    int delJobByID(int id);
}
