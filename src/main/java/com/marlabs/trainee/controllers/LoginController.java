package com.marlabs.trainee.controllers;

import com.marlabs.trainee.dao.impls.UserImpl;
import com.marlabs.trainee.dao.interfaces.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Rico on 7/10/15.
 */
@Controller
public class LoginController {
    @Autowired
    private UserDao userDao = new UserImpl();


}
