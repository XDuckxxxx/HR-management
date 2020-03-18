package com.example.demo.controller;


import com.example.demo.entity.Notice;
import com.example.demo.service.noticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller

@RequestMapping("notice")
public class NoticeController {

    @Autowired
    private noticeService noticeService;

    @GetMapping("/list")
    public String getAll(Model model){
        List<Notice> noticeList=noticeService.getAll();
        model.addAttribute("notice",noticeList);
        return "noticeIndex";
    }

    @GetMapping("/addNote")
    public String addNote(){
        return "noticeAdd";
    }

    @PostMapping("/postNote")
    public String postNote(Notice notice){
        noticeService.insNotice(notice);
        return "redirect:/user/managerNotice";
    }

    @GetMapping("/update/{id}")
    public String updateNote(@PathVariable("id")int id,Model model){
        Notice notice=noticeService.getNoiceByID(id);
        model.addAttribute("note",notice);
        return "noticeUpdate";
    }



    @PostMapping("/update")
    public String updateNoticeByID(Notice notice){
        noticeService.updateNoticeByID(notice);
        return "redirect:/user/managerNotice";
    }

    @GetMapping("/delNote/{id}")
    public String delNoticeByID(@PathVariable("id")int id){
        noticeService.delNoticeByID(id);
        return "redirect:/user/managerNotice";
    }
}
