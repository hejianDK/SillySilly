package com.marlabs.trainee.utils;

import com.marlabs.trainee.model.Car;
import com.marlabs.trainee.model.Claim;
import com.marlabs.trainee.model.Insurance;
import com.marlabs.trainee.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtils {
    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Car.class);
            configuration.addAnnotatedClass(Insurance.class);
            configuration.addAnnotatedClass(Claim.class);
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties());
            return sessionFactory = configuration.buildSessionFactory(builder.build());
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory failed with: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory == null ? buildSessionFactory() : sessionFactory;
    }
}
