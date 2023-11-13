package com.example.doantotnghiep1.service;

import com.example.doantotnghiep1.entity.Feedback;

import java.util.List;

public interface FeedbackService {
    Feedback add(Feedback feedback);

    List<Feedback> getAll();

    Feedback getOne(String id);
}
