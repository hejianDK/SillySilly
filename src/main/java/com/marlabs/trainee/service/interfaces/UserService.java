package com.marlabs.trainee.service.interfaces;

import com.marlabs.trainee.model.User;

/**
 * Created by Rico on 7/21/15.
 */
public interface UserService {
    public long register(User u);
    public User getProfile(long uid);
}
