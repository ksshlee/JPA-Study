package com.study.jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
