package com.study.jpa;

import com.study.jpa.entity.Account;
import com.study.jpa.entity.Study;
import com.study.jpa.types.UserType;
import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Account account = new Account();
        account.setUserName("Sang Hyuk");
        account.setPassword("1234");
        account.setUserType(UserType.NORMAL);

        Account account1 = new Account();
        account1.setUserName("Jack");
        account1.setPassword("12345");
        account1.setUserType(UserType.NORMAL);

        Study study1 = new Study();
        study1.setName("jpa study");
        study1.setUser(account);

        Study study2 = new Study();
        study2.setName("coding test");
        study2.setUser(account);

        Study study3 = new Study();
        study3.setName("jpa study2");
        study3.setUser(account1);

        Study study4 = new Study();
        study4.setName("coding test2");
        study4.setUser(account1);

        Session session = entityManager.unwrap(Session.class);

        session.save(account);
        session.save(account1);
        session.save(study1);
        session.save(study2);
        session.save(study3);
        session.save(study4);
    }
}
