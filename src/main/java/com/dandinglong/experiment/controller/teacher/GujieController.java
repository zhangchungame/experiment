package com.dandinglong.experiment.controller.teacher;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/teacher/gujie")
public class GujieController {

    @RequestMapping(value = "initData",method = RequestMethod.GET)
    public ModelAndView initDataGet(){
        ModelAndView modelAndView=new ModelAndView("teacher/gujieInitData");
        return modelAndView;
    }

    @RequestMapping(value = "initData",method = RequestMethod.POST)
    public ModelAndView initDataPost(){
        ModelAndView modelAndView=new ModelAndView("teacher/gujieInitData");
        return modelAndView;
    }

}
