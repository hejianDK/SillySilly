package com.marlabs.trainee.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Rico on 7/5/15.
 */
public enum  JPAUtil {
    INSTANCE;
    private final EntityManagerFactory entityManagerFactory;
    JPAUtil(){
        entityManagerFactory = Persistence.createEntityManagerFactory("com.marlabs.trainee.jpa");
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
