package com.dandinglong.experiment.controller.teacher;


import com.dandinglong.experiment.dto.MaClassInfo;
import com.dandinglong.experiment.dto.MaTeacher;
import com.dandinglong.experiment.service.TeacherBaseActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("/teacher")
public class TeacherBaseActionController {
    @Autowired
    private TeacherBaseActionService teacherBaseActionService;
    @RequestMapping("")
    public ModelAndView index(){
        ModelAndView modelAndView=new ModelAndView("teacher/index");
        return modelAndView;
    }

    @RequestMapping(value = "createClass",method = RequestMethod.GET)
    public ModelAndView createClassGet(@RequestParam(value = "id",defaultValue = "0") int id){
        ModelAndView modelAndView=new ModelAndView("teacher/createClass");
        MaClassInfo maClassInfo=teacherBaseActionService.findClassInfo(id);
        if(maClassInfo==null){
            maClassInfo=new MaClassInfo();
        }
        modelAndView.addObject("maClassInfo",maClassInfo);
        return modelAndView;
    }
    @RequestMapping(value = "createClass",method = RequestMethod.POST)
    public void createClassPost(@RequestParam("className")String className,
                                @RequestParam("grade")String grade,
                                @RequestParam(value = "id",defaultValue = "0")int id,
                                HttpServletResponse response) throws IOException {
        MaClassInfo maClassInfo=new MaClassInfo();
        maClassInfo.setClassName(className);
        maClassInfo.setGrade(grade);
        maClassInfo.setId(id);
        teacherBaseActionService.saveClassInfo(maClassInfo);
        response.sendRedirect("/teacher/classList");
    }
    @RequestMapping("test")
    public MaTeacher test(){
        MaTeacher maTeacher=new MaTeacher();
        maTeacher.setLastLoginTime(new Date());
        maTeacher.setAccount("aaa");
        return maTeacher;
    }
}
