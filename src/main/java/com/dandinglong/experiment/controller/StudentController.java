package com.dandinglong.experiment.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/student")
public class StudentController {
    @RequestMapping("index")
    public ModelAndView index(){
        ModelAndView modelAndView=new ModelAndView("student/index");
        return modelAndView;
    }

    @RequestMapping("gujie")
    public ModelAndView gujie(){
        ModelAndView modelAndView=new ModelAndView("student/gujie_index");
        return modelAndView;
    }

    @RequestMapping("drag")
    public ModelAndView drag(){
        ModelAndView modelAndView=new ModelAndView("student/gujie_drag");
        return modelAndView;
    }

    @RequestMapping("inputdata")
    public ModelAndView inputData() {
        ModelAndView modelAndView = new ModelAndView("student/gujie_inputData");
        return modelAndView;
    }
}
