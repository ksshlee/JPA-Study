package com.study.jpa.entity;

import com.study.jpa.types.UserType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Account {
    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true,length = 10)
    private String userName;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private UserType userType;

    @Column(nullable = false)
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "home_city")),
            @AttributeOverride(name = "country", column = @Column(name = "home_country")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "home_zip_code"))
    })
    private Address home_address;

    @Transient
    private String doNotMap;

    @OneToMany(mappedBy = "user")
    Set<Study> studies = new HashSet<>();
}
