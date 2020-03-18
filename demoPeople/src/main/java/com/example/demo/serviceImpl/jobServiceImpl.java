package com.example.demo.serviceImpl;


import com.example.demo.entity.Job;
import com.example.demo.mapper.jobMapper;
import com.example.demo.service.jobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class jobServiceImpl implements jobService {

    @Autowired
    private jobMapper jobMapper;

    @Override
    public List<Job> getAll() {
        return jobMapper.getAll();
    }

    @Override
    public int insJob(Job job) {
        return jobMapper.insJob(job);
    }

    @Override
    public Job getJobByID(int id) {
        return jobMapper.getJobByID(id);
    }

    @Override
    public int updateJobByID(Job job) {
        return jobMapper.updateJobByID(job);
    }

    @Override
    public int delJobByID(int id) {
        return jobMapper.delJobByID(id);
    }
}
