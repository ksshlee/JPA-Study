package com.study.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Study {
    @Id @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private Account user;
}