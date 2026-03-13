package com.bulletin.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class PostSummaryResponse {
    private Integer id;
    private String title;
    private String authorName;
    private int viewCount;
    private LocalDateTime createdAt;
}
