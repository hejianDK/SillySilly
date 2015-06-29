package com.marlabs.trainee;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by Rico on 6/29/15.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static SessionFactory buildSessionFactory(){
        try {
            Configuration configuration = new Configuration().configure();
            System.out.println("Hibernate Configuration loaded.");
            StandardServiceRegistry ssrb = new StandardServiceRegistryBuilder().
                    applySettings(configuration.getProperties()).build();
            System.out.println("Standard Service Registry loaded");
            return configuration.buildSessionFactory(ssrb);
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory failed with: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory == null ? buildSessionFactory() : sessionFactory;
    }

}
