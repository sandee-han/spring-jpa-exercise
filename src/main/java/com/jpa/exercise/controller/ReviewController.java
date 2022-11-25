package com.jpa.exercise.controller;

import com.jpa.exercise.domain.Review;
import com.jpa.exercise.domain.dto.ReviewReadResponse;
import com.jpa.exercise.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor    // 필요한 argument 넣어줌
@RequestMapping("/api/v1/reviews")
@Slf4j
public class ReviewController {

    private final ReviewService reviewService;

    // 1개 조회 기능
    // GET /api/v1/review/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ReviewReadResponse> get(@PathVariable Long id) {
        Review review = reviewService.getReview(id);
        ReviewReadResponse response = ReviewReadResponse.builder()
                .id(review.getId())
                .title(review.getTitle())
                .content(review.getContent())
                .patientName(review.getPatientName())
                .hospitalName(review.getHospital().getHospitalName())
                .build();
        return ResponseEntity.ok().body(response);
    }
}
