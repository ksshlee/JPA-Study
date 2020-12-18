package com.study.jpa.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Comment {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @Setter
    private Post post;

    @Setter
    private String content;

    @Builder
    public Comment(String content, Post post){
        this.content = content;
        this.post = post;
    }
}
