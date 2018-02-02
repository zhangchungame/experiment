package com.dandinglong.experiment.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/login")
public class LoginController {
    @RequestMapping("")
    public ModelAndView login(){
        ModelAndView modelAndView=new ModelAndView("login/login");
        return modelAndView;
    }
}
