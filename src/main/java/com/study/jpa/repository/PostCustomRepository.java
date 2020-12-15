package com.study.jpa.repository;

import com.study.jpa.entity.Post;

import java.util.List;

public interface PostCustomRepository {

    void customRepository();

    void findAllById(Long id);

    List<Post> findPostWithQueryDsl(String contentKeyword, Long likeCount);
}
