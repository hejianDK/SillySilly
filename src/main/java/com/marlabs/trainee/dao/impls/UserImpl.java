package com.marlabs.trainee.dao.impls;

import com.marlabs.trainee.dao.interfaces.UserDao;
import com.marlabs.trainee.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository("userDao")
public class UserImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public long saveUser(User u) {

        Serializable id = sessionFactory.getCurrentSession().save(u);
        return (long)id;
    }

    @Override
    public void deleteUser(User u) {
        sessionFactory.getCurrentSession().delete(u);
    }

    @Override
    public List<User> getAllUsers() {
        return sessionFactory.getCurrentSession().createQuery("FROM User").list();
    }


    @Override
    public User getUserByUserName(String userName) {
        return (User)sessionFactory.getCurrentSession().createQuery("FROM User AS u WHERE userName=:userName").
                setString("userName",userName).uniqueResult();
    }

    @Override
    public User getUserById(long id) {
        return (User)sessionFactory.getCurrentSession().get(User.class,id);
    }
}
