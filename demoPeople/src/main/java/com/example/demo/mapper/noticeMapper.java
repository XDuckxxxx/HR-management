package com.example.demo.mapper;


import com.example.demo.entity.Notice;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface noticeMapper {
    @Select("select * from oa_notice")
    List<Notice>getAll();

    @Insert("insert into oa_notice(Notice_id,Title,Content,Create_time,User_id) values(0,#{Title},#{Content},#{Create_time},#{User_id})")
    int insNotice(Notice notice);

    @Select("select * from oa_notice where Notice_id=#{id}")
    Notice getNoticeByID(int id);

    @Update("update oa_notice set Title=#{Title},Content=#{Content},Create_time=#{Create_time},User_id=#{User_id} where Notice_id=#{Notice_id}")
    int updateNoticeByID(Notice notice);

    @Delete("DELETE from oa_notice WHERE Notice_id=#{Notice_id}")
    int delNoticeByID(int id);
}
