package com.study.jpa.repository;


import com.study.jpa.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long>,PostCustomRepository { // custom repo 도 extend
    List<Post> findByContentContainsIgnoreCase(String keyword);

    Long countByLikeCountsIsGreaterThanEqual(Long count);

    List<Post> findByContentContainsIgnoreCaseAndLikeCountsGreaterThanEqual(String keyword,Long likeCount);

    List<Post> findByContentContainsIgnoreCaseAndLikeCountsGreaterThanEqualOrderByLikeCountsDesc(String keyword,Long likeCount);

    Post findContent (String keyword);

    Post findContentNative(String keyword);

    @Query("select p from Post As p where p.title = ?1")
    Post findTitle (String keyword);

    @Query(value = "select * from post where title = ?",nativeQuery = true)
    Post findTitleNative (String keyword);
}
