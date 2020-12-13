package com.study.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
public class Comment {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @Setter
    private Post post;

    @Setter
    private String content;
}
