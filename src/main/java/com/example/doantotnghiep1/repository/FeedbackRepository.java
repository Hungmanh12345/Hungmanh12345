package com.example.doantotnghiep1.repository;

import com.example.doantotnghiep1.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, String> {
}
