package com.study.jpa.repository;

import com.study.jpa.entity.Post;

import java.util.List;

public interface PostCustomRepository<Post,Long> {

    void customRepository();

    void findAllById(Long id);
}
