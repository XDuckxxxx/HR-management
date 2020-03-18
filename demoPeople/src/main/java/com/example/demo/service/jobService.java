package com.example.demo.service;

import com.example.demo.entity.Job;

import java.util.List;

public interface jobService {
    List<Job> getAll();
    int insJob(Job job);
    Job getJobByID(int id);
    int updateJobByID(Job job);
    int delJobByID(int id);
}
