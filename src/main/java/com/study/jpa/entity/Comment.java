package com.study.jpa.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Setter
public class Comment {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    private String content;

    private Long likeCount;

    private Long disLikeCount;

    private Boolean isBlocked;
}
