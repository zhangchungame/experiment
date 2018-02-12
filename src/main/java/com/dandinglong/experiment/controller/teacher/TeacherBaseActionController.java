package com.dandinglong.experiment.controller.teacher;


import com.alibaba.fastjson.JSON;
import com.dandinglong.experiment.dao.PageInfo;
import com.dandinglong.experiment.dao.RespRestfulDto;
import com.dandinglong.experiment.dto.MaClassInfo;
import com.dandinglong.experiment.dto.MaStudent;
import com.dandinglong.experiment.dto.MaTeacher;
import com.dandinglong.experiment.service.TeacherBaseActionService;
import com.dandinglong.experiment.util.RespCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherBaseActionController {
    @Autowired
    private TeacherBaseActionService teacherBaseActionService;

    @RequestMapping("")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("teacher/index");
        return modelAndView;
    }

    @RequestMapping(value = "createClass", method = RequestMethod.GET)
    public ModelAndView createClassGet(@RequestParam(value = "id", defaultValue = "0") int id) {
        ModelAndView modelAndView = new ModelAndView("teacher/createClass");
        MaClassInfo maClassInfo = teacherBaseActionService.findClassInfo(id);
        if (maClassInfo == null) {
            maClassInfo = new MaClassInfo();
        }
        modelAndView.addObject("maClassInfo", maClassInfo);
        return modelAndView;
    }

    @RequestMapping(value = "createClass", method = RequestMethod.POST)
    public void createClassPost(@RequestParam("className") String className,
                                @RequestParam("grad") String grad,
                                @RequestParam(value = "id", defaultValue = "0") int id,
                                HttpServletResponse response) throws IOException {
        MaClassInfo maClassInfo = new MaClassInfo();
        maClassInfo.setClassName(className);
        maClassInfo.setGrad(grad);
        maClassInfo.setId(id);
        teacherBaseActionService.saveClassInfo(maClassInfo);
        response.sendRedirect("/teacher/classList");
    }

    @RequestMapping(value = "createClass", method = RequestMethod.DELETE)
    public RespRestfulDto createClassDelete(@RequestParam(value = "id", defaultValue = "0") int id) {

        try {
            RespRestfulDto respRestfulDto = RespCommon.success(teacherBaseActionService.delClassInfo(id));
            return respRestfulDto;
        } catch (Exception e) {
            return RespCommon.fail(e);
        }
    }

    @RequestMapping(value = "classList", method = RequestMethod.GET)
    public ModelAndView classList(@RequestParam(value = "page", defaultValue = "1") int page) {
        PageInfo pageInfo = teacherBaseActionService.classList(page);
        ModelAndView modelAndView = new ModelAndView("teacher/classList");
        modelAndView.addObject("pageInfo", pageInfo);
        return modelAndView;
    }

    @RequestMapping(value = "batchCreateStudent", method = RequestMethod.GET)
    public ModelAndView batchCreateStudentGet(@RequestParam(value = "id", defaultValue = "0") int id) {
        ModelAndView modelAndView = new ModelAndView("teacher/batchCreateStudent");
        MaStudent maStudent = teacherBaseActionService.findStudent(id);
        if (maStudent == null) {
            maStudent = new MaStudent();
        }
        modelAndView.addObject("maStudent", maStudent);
        modelAndView.addObject("maClassList", JSON.toJSONString(teacherBaseActionService.findAllClassInfo()));
        return modelAndView;
    }

    @RequestMapping(value = "batchCreateStudent", method = RequestMethod.POST)
    public RespRestfulDto batchCreateStudent(@RequestBody List<MaStudent> studentList) {
        try {
            RespRestfulDto respRestfulDto = RespCommon.success(teacherBaseActionService.batchCreateStudent(studentList));
            return respRestfulDto;
        } catch (Exception e) {
            return RespCommon.fail(e);
        }
    }


    @RequestMapping(value = "studentList", method = RequestMethod.GET)
    public ModelAndView studentList(@RequestParam(value = "page", defaultValue = "1") int page) {
        PageInfo pageInfo = teacherBaseActionService.studentList(page);
        ModelAndView modelAndView = new ModelAndView("teacher/studentList");
        modelAndView.addObject("pageInfo", pageInfo);
        return modelAndView;
    }

    @RequestMapping(value = "createStudent", method = RequestMethod.GET)
    public ModelAndView createStudent(@RequestParam(value = "id", defaultValue = "0") int id) {
        ModelAndView modelAndView = new ModelAndView("teacher/createStudent");
        MaStudent maStudent = teacherBaseActionService.findStudent(id);
        if (maStudent == null) {
            maStudent = new MaStudent();
        }
        modelAndView.addObject("maStudent", maStudent);
        return modelAndView;
    }

    @RequestMapping(value = "createStudent", method = RequestMethod.POST)
    public void createStudentPost(@RequestParam("name") String name,
                                          @RequestParam("password") String password,
                                          @RequestParam(value = "id", defaultValue = "0") int id,
                                          HttpServletResponse response) throws IOException {
        MaStudent maStudent=new MaStudent();
        maStudent.setId(id);
        maStudent.setName(name);
        maStudent.setPassword(password);
        teacherBaseActionService.saveStudent(maStudent);
        response.sendRedirect("/teacher/studentList");
    }

    @RequestMapping(value = "createStudent", method = RequestMethod.DELETE)
    public RespRestfulDto createStudentDelete(@RequestParam(value = "id", defaultValue = "0") int id) {

        try {
            RespRestfulDto respRestfulDto = RespCommon.success(teacherBaseActionService.delStudent(id));
            return respRestfulDto;
        } catch (Exception e) {
            return RespCommon.fail(e);
        }
    }
}
