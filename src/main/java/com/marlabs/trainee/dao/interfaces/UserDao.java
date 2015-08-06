package com.marlabs.trainee.dao.interfaces;

import com.marlabs.trainee.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Rico on 7/1/15.
 */

public interface UserDao {
    public long saveUser(User u);
    public void deleteUser(User u);
    public List<User> getAllUsers();
    public User getUserByUserName(String userName);
    public User getUserById(long id);
}
