package com.marlabs.trainee.service.impls;

import com.marlabs.trainee.dao.interfaces.UserDao;
import com.marlabs.trainee.model.User;
import com.marlabs.trainee.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Rico on 7/21/15.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public long register(User u) {
        return userDao.saveUser(u);
    }

    @Override
    public User getProfile(long uid) {
        return userDao.getUserById(uid);
    }
}
