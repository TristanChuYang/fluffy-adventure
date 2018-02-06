package com.chuyang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView login(String username, String password) {

        if (null == username || null == password || "".equals(username) || "".equals(password)) {

            return new ModelAndView("home");
        }

        ModelAndView modelAndView = new ModelAndView("succ");
        modelAndView.addObject("username", username);
        modelAndView.addObject("password", password);

        return modelAndView;

    }


}
