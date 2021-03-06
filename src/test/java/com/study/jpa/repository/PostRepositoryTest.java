package com.study.jpa.repository;

import com.study.jpa.entity.Comment;
import com.study.jpa.entity.Post;
import com.study.jpa.projection.CommentProjectionByClass;
import com.study.jpa.projection.CommentProjectionByInterface;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.OPTIONAL;


@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @Before
    public void beforeJpaTest(){
        Post post1 = Post.builder().content("spring post1").title("spring post1").likeCounts(3L).build();
        Post post2 = Post.builder().content("test content p").title("test title").likeCounts(15L).build();
        Post post3 = Post.builder().content("ppp").title("bbb").likeCounts(16L).build();

        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);
    }


    @Test
    public void postRepositoryQueryTest(){
        // 문자열을 content 에 포함한 게시글들 찾기
        List<Post> postList = postRepository.findByContentContainsIgnoreCase("p");

        // 테스트 결과
        assertThat(postList.size()).isEqualTo(3L);


        // 좋아요 개수로 게시글 개수 count
        long count = postRepository.countByLikeCountsIsGreaterThanEqual(11L);

        // 결과 확인
        assertThat(count).isEqualTo(2L);


        // 좋아요 기준보다 크고 대소문자 상관없이 포함되어 있고
        List<Post> posts = postRepository.findByContentContainsIgnoreCaseAndLikeCountsGreaterThanEqualOrderByLikeCountsDesc("p",10L);

        assertThat(posts).first().hasFieldOrPropertyWithValue("likeCounts",16L);



        postRepository.customRepository();

        // 커스텀하게 구현한건 우선순위가 최상단
        postRepository.findAllById(1L);
    }

    @Test
    public void queryDslTest() {
        // p 를 포함하고 좋아요 10 이상인 게시글 찾기
        List<Post> postList = postRepository.findPostWithQueryDsl("p",10L);

        assertThat(postList).first().hasFieldOrPropertyWithValue("likeCounts",16L);

    }

    @Test
    public void namedQueryTest(){
        Post post = postRepository.findContent("ppp");
        Post postNative = postRepository.findContentNative("ppp");

        assertThat(post).isNotNull();
        assertThat(postNative).isNotNull();
    }

    @Test
    public void queryTest(){
        Post post = postRepository.findTitle("bbb");
        Post postNative = postRepository.findTitleNative("bbb");

        assertThat(post).isNotNull();
        assertThat(postNative).isNotNull();
    }

    @Test
    public void entityGraph(){
        Optional<Comment> comment = commentRepository.findById(1L);

        System.out.println("====================");

        Comment comment1 = commentRepository.getById(1L);
    }

    @Test
    public void projectionTest(){
        Post post = Post.builder().content("post1").likeCounts(0L).title("post1").build();

        Post savedPost = postRepository.save(post);

        Comment comment = new Comment();
        comment.setPost(savedPost);
        comment.setContent("comment1");
        comment.setLikeCount(11L);
        comment.setDisLikeCount(0L);
        comment.setIsBlocked(false);

        Comment savedComment = commentRepository.save(comment);

        commentRepository.findByPost_Id(savedPost.getId(),Comment.class).forEach(c ->{
            System.out.println(c.getContent());
        });

        System.out.println("=========================");


        commentRepository.findByPost_Id(savedPost.getId(),CommentProjectionByInterface.class).forEach(c ->{
            System.out.println(c.getTotalReactions());
        });

        System.out.println("=========================");


        commentRepository.findByPost_Id(savedPost.getId(), CommentProjectionByClass.class).forEach(c ->{
            System.out.println(c.getTotalReactions());
        });


    }
}