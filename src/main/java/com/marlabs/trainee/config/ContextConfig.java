package com.marlabs.trainee.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Rico on 7/21/15.
 */
@Configuration
@ImportResource("classpath:/application-context.xml")
@ComponentScan(basePackages = {
        "com.marlabs.trainee.dao.impls",
        "com.marlabs.trainee.service.impls"})
//@EnableTransactionManagement
public class ContextConfig {

//    @Autowired
//    @Bean
//    public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory){
//        HibernateTransactionManager manager = new HibernateTransactionManager(sessionFactory);
//        return manager;
//    }
}
