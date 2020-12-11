package com.study.jpa.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String zipCode;

    private String city;

    private String country;
}
