package com.bulletin.controller;

import com.bulletin.base.BaseResponse;
import com.bulletin.dto.*;
import com.bulletin.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/all")
    public ResponseEntity<BaseResponse<List<PostSummaryResponse>>> getListPosts() {
        List<PostSummaryResponse> postSummaryResponses = postService.getListPosts();
        return ResponseEntity.ok(BaseResponse.success("post list retrieved",postSummaryResponses));
    }

    @GetMapping("/{postId}")
    public ResponseEntity<BaseResponse<PostDetailResponse>> viewPostDetail(@PathVariable Integer postId) {
        PostDetailResponse postDetailResponse = postService.viewPostDetail(postId);
        return ResponseEntity.ok(BaseResponse.success("게시글 조회 성공",postDetailResponse));
    }

    @PostMapping("/create")
    public ResponseEntity<BaseResponse<PostDetailResponse>> createPost(@RequestBody PostCreateRequest postCreateRequest) {
        PostDetailResponse PostDetailResponse = postService.createPost(postCreateRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(BaseResponse.success("게시글 등록 성공", PostDetailResponse));
    }

    @PutMapping("/{postId}")
    public ResponseEntity<BaseResponse<PostDetailResponse>> modifyPost(@PathVariable Integer postId, @RequestBody PostModifyRequest postModifyRequest) {
        PostDetailResponse postDetailResponse = postService.modifyPost(postId, postModifyRequest);
        return ResponseEntity.ok(BaseResponse.success("게시글 수정 성공",postDetailResponse));
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<BaseResponse<Void>> deletePost(@PathVariable Integer postId, @Valid @RequestBody PostDeleteRequest postDeleteRequest) {
        postService.deletePost(postId, postDeleteRequest);
        return ResponseEntity.ok(BaseResponse.success("게시글 삭제 성공",null));
    }
}
