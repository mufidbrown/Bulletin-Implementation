package com.bulletin.entity.mapper;

import com.bulletin.dto.PostDetailResponse;
import com.bulletin.dto.PostSummaryResponse;
import com.bulletin.entity.Post;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    public PostSummaryResponse toPostSummaryResponse(Post post) {

        PostSummaryResponse postSummaryResponse = new PostSummaryResponse();
        postSummaryResponse.setId(post.getId());
        postSummaryResponse.setTitle(post.getTitle());
        postSummaryResponse.setAuthorName(post.getAuthorName());
        postSummaryResponse.setViewCount(post.getViewCount());
        postSummaryResponse.setCreatedAt(post.getCreatedAt());

        return postSummaryResponse;
    }

    public PostDetailResponse toDetailResponse(Post post) {

        PostDetailResponse postDetailResponse = new PostDetailResponse();
        postDetailResponse.setId(post.getId());
        postDetailResponse.setTitle(post.getTitle());
        postDetailResponse.setAuthorName(post.getAuthorName());
        postDetailResponse.setContent(post.getContent());
        postDetailResponse.setViewCount(post.getViewCount());
        postDetailResponse.setCreatedAt(post.getCreatedAt());
        postDetailResponse.setModifiedAt(post.getModifiedAt());

        return postDetailResponse;
    }
}
