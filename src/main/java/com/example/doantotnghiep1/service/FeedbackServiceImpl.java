package com.example.doantotnghiep1.service;

import com.example.doantotnghiep1.entity.Feedback;
import com.example.doantotnghiep1.repository.FeedbackRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService{
    private final FeedbackRepository feedbackRepository;

    public FeedbackServiceImpl(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public Feedback add(Feedback feedback){
        return feedbackRepository.save(feedback);
    }

    @Override
    public List<Feedback> getAll(){
        return feedbackRepository.findAll();
    }

    @Override
    public Feedback getOne(String id){
        return feedbackRepository.findById(id).get();
    }
}
