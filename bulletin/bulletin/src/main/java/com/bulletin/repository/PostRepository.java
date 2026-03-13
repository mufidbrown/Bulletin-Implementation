package com.bulletin.repository;

import com.bulletin.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query("SELECT p FROM Post p WHERE p.deleted = false ORDER BY p.id ASC")
    List<Post> findAllListPosts();

    @Query("SELECT p FROM Post p WHERE p.id = :postId AND p.deleted = false")
    Optional<Post> findActivePostById(@Param("postId") Integer postId);

}
