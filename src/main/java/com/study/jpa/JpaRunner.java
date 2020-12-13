package com.study.jpa;

import com.study.jpa.entity.Account;
import com.study.jpa.entity.Comment;
import com.study.jpa.entity.Post;
import com.study.jpa.entity.Study;
import com.study.jpa.types.UserType;
import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Set;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {

//        Post post = new Post();
//        post.setContent("post");
//
//        Comment comment = new Comment();
//        comment.setContent("comment1");
//        comment.setPost(post);
//
//
//        Comment comment2 = new Comment();
//        comment2.setContent("comment2");
//        comment2.setPost(post);
////
////
        Session session = entityManager.unwrap(Session.class);
////
//        session.save(post);
//        session.save(comment);
//        session.save(comment2);

        Post post = session.get(Post.class,1L);

        session.delete(post);
    }
}
