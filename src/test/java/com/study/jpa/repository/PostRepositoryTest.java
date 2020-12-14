package com.study.jpa.repository;

import com.study.jpa.entity.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    public void crudRepo(){
        Post post = new Post();
        post.setContent("asd");
        Post newPost = postRepository.save(post);

        assertThat(newPost.getId()).isNotNull();
    }


}