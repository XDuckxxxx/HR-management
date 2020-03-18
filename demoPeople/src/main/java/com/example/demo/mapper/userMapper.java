package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface userMapper {

    @Select("select * from oa_user")
    List<User> getAll();
    @Select("SELECT * FROM   oa_user where User_name=#{account} and Password=#{password}")
    User userLogin(@Param("account") String uname, @Param("password") String pwd);
    @Insert("insert into oa_user(User_id,Account,User_name,Password,Status,Role_name) values(0,#{Account},#{User_name},#{Password},#{Status},#{Role_name})")
    int insUser(User user);
    @Select("select * from oa_user where User_id=#{User_id}")
    User getUserByID(int id);
    @Update("update oa_user set Account=#{Account},User_name=#{User_name},Password=#{Password},Status=#{Status},Role_name=#{Role_name} where User_id=#{User_id}")
    int updateUserByID(User user);
    @Delete("DELETE from oa_user WHERE User_id=#{User_id}")
    int delUserByID(int id);
    @Select("select * from oa_user where User_name=#{User_name}")
    User getUserByName(String username);
}
