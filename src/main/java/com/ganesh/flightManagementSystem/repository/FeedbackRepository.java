package com.ganesh.flightManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ganesh.flightManagementSystem.bean.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
