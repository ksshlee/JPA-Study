package com.study.jpa.repository;


import com.study.jpa.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findByContentContainsIgnoreCase(String keyword);

    Long countByLikeCountsIsGreaterThanEqual(Long count);

    List<Post> findByContentContainsIgnoreCaseAndLikeCountsGreaterThanEqual(String keyword,Long likeCount);

    List<Post> findByContentContainsIgnoreCaseAndLikeCountsGreaterThanEqualOrderByLikeCountsDesc(String keyword,Long likeCount);
}
