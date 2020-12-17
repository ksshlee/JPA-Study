package com.study.jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@NamedQuery(name = "Post.findContent",query = "select p from Post as p where p.content like ?1")
@NamedNativeQuery(name = "Post.findContentNative", query = "select * from post where content like ?",resultClass = Post.class)
public class Post {
    @Id @GeneratedValue
    private Long id;

    private String title;

    @Lob
    private String content;

    private Long likeCounts;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Comment> comments;

    @Builder
    public Post(String title, String content, Long likeCounts){
        this.title = title;
        this.content = content;
        this.likeCounts = likeCounts;
    }
}
