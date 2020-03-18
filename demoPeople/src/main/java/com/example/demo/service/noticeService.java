package com.example.demo.service;

import com.example.demo.entity.Notice;

import java.util.List;

public interface noticeService {
    List<Notice>getAll();
    int insNotice(Notice notice);
    Notice getNoiceByID(int id);
    int updateNoticeByID(Notice notice);
    int delNoticeByID(int id);
}
