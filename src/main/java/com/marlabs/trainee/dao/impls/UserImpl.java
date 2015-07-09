package com.marlabs.trainee.dao.impls;

import com.marlabs.trainee.dao.interfaces.UserDao;
import com.marlabs.trainee.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Rico on 7/9/15.
 */
@Repository(value = "UserDao")
@Transactional
public class UserImpl implements UserDao{
    @Autowired
    private SessionFactory sessionFactory;

    private Session session = sessionFactory.getCurrentSession();
    @Override
    public User saveUser(User u) {
        session.saveOrUpdate(u);
        return u;
    }

    @Override
    public void deleteUser(User u) {
        session.delete(u);
    }

    @Override
    public List<User> getAllUsers() {
        return session.createQuery("FROM User").list();
    }


    @Override
    public User getUserByUserName(String userName) {
        return (User)session.createQuery("FROM User AS u WHERE u.userName:userName").
                setString("userName",userName).uniqueResult();
    }

    @Override
    public User getUserById(long id) {
        return session.get(User.class,id);
    }
}
