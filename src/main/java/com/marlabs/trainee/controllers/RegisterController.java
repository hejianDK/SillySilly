package com.marlabs.trainee.controllers;

import com.marlabs.trainee.dao.interfaces.UserDao;
import com.marlabs.trainee.model.User;
import com.marlabs.trainee.service.interfaces.UserService;
import com.marlabs.trainee.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.util.Map;

/**
 * Created by Rico on 7/20/15.
 */
@Controller
@RequestMapping("/register")
public class RegisterController {
    private UserService userService;

    @Autowired
    public RegisterController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String register(){
        return "register-form";
    }

    @RequestMapping( value = "/u",method = RequestMethod.GET)
    public String getProfile(Model model){
        model.addAttribute("user",userService.getProfile(2));
        return "index";
    }
}
