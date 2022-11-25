package com.jpa.exercise.service;

import com.jpa.exercise.domain.Hospital;
import com.jpa.exercise.domain.Review;
import com.jpa.exercise.domain.dto.ReviewCreateRequest;
import com.jpa.exercise.domain.dto.ReviewCreateResponse;
import com.jpa.exercise.repository.HospitalRepository;
import com.jpa.exercise.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {
    // service에서 hospitalId로 hospital을 먼저 조회해야 하기 때문에 hospitalRepository사용
    private final HospitalRepository hospitalRepository;
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository, HospitalRepository hospitalRepository) {
        this.reviewRepository = reviewRepository;
        this.hospitalRepository = hospitalRepository;
    }

    public ReviewCreateResponse createReview(ReviewCreateRequest reviewCreateRequest) {
        // Hospital 불러오기
        Optional<Hospital> hospital = hospitalRepository.findById(reviewCreateRequest.getHospitalId());

        // ReviewEntity만들기
        Review review = Review.builder()
                .title(reviewCreateRequest.getTitle())
                .content(reviewCreateRequest.getContent())
                .patientName(reviewCreateRequest.getPatientName())
                .hospital(hospital.get())
                .build();

        // 저장
        Review savedReview = reviewRepository.save(review);
        return new ReviewCreateResponse(savedReview.getId(), savedReview.getTitle(), savedReview.getContent(), savedReview.getPatientName(),
                "리뷰 등록이 성공 했습니다.");
    }

    public Review getReview(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("해당 id가 없습니다."));    // 에러 처리
        return review;
    }
}