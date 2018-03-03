package com.dandinglong.experiment.controller;


import com.dandinglong.experiment.dto.MaStudent;
import com.dandinglong.experiment.dto.MaTeacher;
import com.dandinglong.experiment.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("")
    public ModelAndView login(){
        ModelAndView modelAndView=new ModelAndView("login/login");
        return modelAndView;
    }
    @RequestMapping(value = "student",method = RequestMethod.POST)
    public void loginStudent(@RequestParam(name = "studentNo",required = true)String studentNo,
                             @RequestParam(name = "password",required = true)String password,
                             HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session=request.getSession();
        try{
            MaStudent maStudent=loginService.studentLogin(studentNo,password);
            session.setAttribute("maStudent",maStudent);
            response.sendRedirect("/student/");
        }catch (Exception e){
            session.setAttribute("loginErrorMsg",e.getMessage());
            response.sendRedirect("/login/");
        }

    }
    @RequestMapping(value = "student/loginout")
    public void loginoutStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session=request.getSession();
        try{
            session.setAttribute("maStudent",null);
            response.sendRedirect("/login/");
        }catch (Exception e){
            session.setAttribute("loginErrorMsg",e.getMessage());
            response.sendRedirect("/login/");
        }

    }
    @RequestMapping(value = "teacher",method = RequestMethod.POST)
    public void loginTeacher(@RequestParam(name = "account",required = true)String account,
                             @RequestParam(name = "password",required = true)String password,
                             HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session=request.getSession();
        try{
            MaTeacher maTeacher=loginService.teacherLogin(account,password);
            session.setAttribute("maTeacher",maTeacher);
            response.sendRedirect("/teacher/");
        }catch (Exception e){
            session.setAttribute("loginErrorMsg",e.getMessage());
            response.sendRedirect("/login/");
        }
    }

    @RequestMapping(value = "teacher/loginout")
    public void loginoutTeacher(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session=request.getSession();
        try{
            session.setAttribute("maTeacher",null);
            response.sendRedirect("/login/");
        }catch (Exception e){
            session.setAttribute("loginErrorMsg",e.getMessage());
            response.sendRedirect("/login/");
        }

    }
}
