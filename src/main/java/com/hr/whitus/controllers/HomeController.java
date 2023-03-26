package com.hr.whitus.controllers;


import com.hr.whitus.dto.FormDataDTO;
import com.hr.whitus.models.User;
import com.hr.whitus.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private UserService userService;
    @GetMapping()
    public ModelAndView indexView()
    {
        ModelAndView mv = new ModelAndView("fibo-app/index");

        return mv;
    }

    @GetMapping("/api")
    public ModelAndView apiView()
    {
        ModelAndView mv = new ModelAndView("fibo-app/api");

        return mv;
    }

    @GetMapping("/users")
    public ModelAndView usersView()
    {
        ModelAndView mv = new ModelAndView("fibo-app/users");
        List<User> listUsers = this.userService.findAll();
        mv.addObject("listUsers", listUsers);
        return mv;
    }
}


