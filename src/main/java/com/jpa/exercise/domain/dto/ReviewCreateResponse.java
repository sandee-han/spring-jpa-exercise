package com.jpa.exercise.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReviewCreateResponse {
    private Long id;
    private String title;
    private String content;
    private String patientName;
    // 리뷰 등록이 잘 되었는지 담는 message
    private String message;
}