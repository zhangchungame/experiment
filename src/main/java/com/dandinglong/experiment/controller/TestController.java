package com.dandinglong.experiment.controller;


import com.dandinglong.experiment.dto.MaStudent;
import com.dandinglong.experiment.mapper.MaStudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    @Autowired
    private MaStudentMapper maStudentMapper;
    @RequestMapping("/test")
    public ModelAndView test(){
        ModelAndView modelAndView=new ModelAndView("test");
        MaStudent maStudent=new MaStudent();
//        maStudent.setBanjiId(2123);
        maStudent.setPassword("sdf");
        maStudent.setStudentNo("sdf");
        maStudent.setName("zc");
        maStudentMapper.insert(maStudent);
        maStudent=maStudentMapper.selectByPrimaryKey(maStudent.getId());
        return modelAndView;
    }
}
