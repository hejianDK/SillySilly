package com.marlabs.trainee.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties());
            return sessionFactory = configuration.buildSessionFactory(ssrb.build());
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory failed with: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory == null ? buildSessionFactory() : sessionFactory;
    }
}
