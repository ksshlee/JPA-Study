package com.study.jpa.repository;

import com.study.jpa.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostCustomRepositoryImpl implements PostCustomRepository<Post,Long> {

    // 커스텀 레포지토리
    // 커스텀한 기능 만들기
    @Override
    public void customRepository() {
        System.out.println("custom repository");
    }

    // 기본 기능 덮어쓰기
    @Override
    public void findAllById(Long id) {
        System.out.println("custom find by id");
    }

}
