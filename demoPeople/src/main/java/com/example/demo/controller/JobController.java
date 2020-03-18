package com.example.demo.controller;


import com.example.demo.entity.Job;
import com.example.demo.entity.User;
import com.example.demo.service.jobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller

@RequestMapping("job")
public class JobController {
    @Autowired
    private jobService jobService;

    @GetMapping("/list")
    public String getAll(Model model, HttpSession session){
//        User user=(User)session.getAttribute("admin");
//        if(user==null){
//            return "sessionFail";
//        }
//        else {
            List<Job> jobList = jobService.getAll();
            model.addAttribute("job", jobList);
            return "jobList";
//        }
    }

    @GetMapping("/addJob")
    public String addJob(){
        return "job-add";
    }

    @PostMapping("/insJob")
    @ResponseBody
    public void insJob(Job job){
        jobService.insJob(job);
    }

    @GetMapping("/update/{id}")
    public String updateJob(@PathVariable("id")int id,Model model){
        Job job=jobService.getJobByID(id);
        model.addAttribute("job",job);
        return "job-update";
    }

    @PostMapping("/update")
    public String updateJobByID(Job job){
        jobService.updateJobByID(job);
        return "redirect:/job/list";
    }

    @GetMapping("/delJob/{id}")
    public String delJobByID(@PathVariable("id")int id){
        jobService.delJobByID(id);
        return "redirect:/job/list";
    }
}
