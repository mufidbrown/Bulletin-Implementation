package com.bulletin.service;

import com.bulletin.dto.*;
import com.bulletin.entity.Post;
import com.bulletin.entity.mapper.PostMapper;
import com.bulletin.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

   public List<PostSummaryResponse> getListPosts() {
       List<Post> posts = postRepository.findAllListPosts();
       return posts.stream()
               .map(postMapper::toPostSummaryResponse)
               .toList();
   }

    public Post getPostById(Integer postId) {
        return postRepository.findActivePostById(postId)
                .orElseThrow(() -> new IllegalArgumentException("post not found"));
    }

    @Transactional
    public PostDetailResponse viewPostDetail(Integer postId){
        Post post = getPostById(postId);
        post.setViewCount(post.getViewCount() + 1);
        Post savePost = postRepository.save(post);
        return postMapper.toDetailResponse(savePost);
    }

    @Transactional
    public PostDetailResponse createPost(PostCreateRequest postCreateRequest) {
        Post post = new Post();
        post.setTitle(postCreateRequest.getTitle());
        post.setAuthorName(postCreateRequest.getAuthorName());
        post.setPassword(postCreateRequest.getPassword());
        post.setContent(postCreateRequest.getContent());
        Post save = postRepository.save(post);
        return postMapper.toDetailResponse(save);
    }

    public boolean verifyPostByPassword(Integer postId, String password) {
        Post post = getPostById(postId);
        return post.getPassword().equals(password);
    }

    @Transactional
    public PostDetailResponse modifyPost(Integer postId, PostModifyRequest postModifyRequest){

        Post post = getPostById(postId);

        if (!verifyPostByPassword(postId, postModifyRequest.getPassword())) {
            throw new IllegalArgumentException("Password does not match");
        }

        post.setTitle(postModifyRequest.getTitle());
        post.setAuthorName(postModifyRequest.getAuthorName());
        post.setContent(postModifyRequest.getContent());
        post.setModifiedAt(LocalDateTime.now());

        Post savePost = postRepository.save(post);

        return postMapper.toDetailResponse(savePost);

    }

    @Transactional
    public void deletePost(Integer postId, PostDeleteRequest request) {

        Post post = getPostById(postId);

        if (!verifyPostByPassword(postId, request.getPassword())) {
            throw new IllegalArgumentException("Password does not match");
        }

        post.setDeleted(true);
        postRepository.save(post);
    }
}
