package com.marlabs.trainee.controllers;

import com.marlabs.trainee.model.User;
import com.marlabs.trainee.service.impls.UserServiceImpl;
import com.marlabs.trainee.service.interfaces.UserService;
import com.marlabs.trainee.utils.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;

/**
 * Created by Rico on 7/20/15.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }
}
