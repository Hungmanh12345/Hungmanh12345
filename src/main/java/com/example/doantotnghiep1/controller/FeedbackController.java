package com.example.doantotnghiep1.controller;

import com.example.doantotnghiep1.entity.Feedback;
import com.example.doantotnghiep1.service.FeedbackService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {
    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping("/information")
    public String information(Model model) {
        Feedback feedback = new Feedback();
        model.addAttribute("feedback", feedback);
        return "information";
    }

    @PostMapping("/add")
    public String addFeedBack(@ModelAttribute("feedback") Feedback feedback){
        feedback
                .name(feedback.getName())
                .phone(feedback.getPhone())
                .content(feedback.getContent());
        feedbackService.add(feedback);
        return "redirect:/feedback/information";
    }

    @GetMapping("/get_feedback")
    public String getFeedback(Model model){
        List<Feedback> feedback = feedbackService.getAll();
        model.addAttribute("feedback", feedback);
        return "feedback";
        }
}
