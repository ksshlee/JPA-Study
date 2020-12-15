package com.study.jpa.repository;

import com.study.jpa.entity.Post;
import com.study.jpa.entity.QPost;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostCustomRepositoryImpl extends QuerydslRepositorySupport implements PostCustomRepository {

    public PostCustomRepositoryImpl() {
        super(Post.class);
    }

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

    @Override
    public List<Post> findPostWithQueryDsl(String contentKeyword, Long likeCount){
        QPost post = QPost.post;
        return from(post)
                .where(post.content.containsIgnoreCase(contentKeyword))
                .where(post.likeCounts.goe(likeCount))
                .orderBy(post.likeCounts.desc())
                .fetch();
    }
}
