package com.example.demo.serviceImpl;

import com.example.demo.entity.Notice;
import com.example.demo.mapper.noticeMapper;
import com.example.demo.service.noticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class noticeServiceImpl implements noticeService {
    @Autowired
    private noticeMapper noticeMapper;

    @Override
    public List<Notice> getAll() {
        return noticeMapper.getAll();
    }

    @Override
    public int insNotice(Notice notice) {
        return noticeMapper.insNotice(notice);
    }

    @Override
    public Notice getNoiceByID(int id) {
        return noticeMapper.getNoticeByID(id);
    }

    @Override
    public int updateNoticeByID(Notice notice) {
        return noticeMapper.updateNoticeByID(notice);
    }

    @Override
    public int delNoticeByID(int id) {
        return noticeMapper.delNoticeByID(id);
    }
}
