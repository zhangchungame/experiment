package com.dandinglong.experiment.config;

import com.dandinglong.experiment.dto.MaTeacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TeacherInterceptor implements HandlerInterceptor {
    private Logger logger= LoggerFactory.getLogger(StudentInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session=req.getSession();
        MaTeacher maTeacher=(MaTeacher)session.getAttribute("maTeacher");
        if(maTeacher==null){
            httpServletResponse.sendRedirect("/login");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        HttpSession session=httpServletRequest.getSession();
        MaTeacher maTeacher=(MaTeacher)session.getAttribute("maTecher");
        if(modelAndView!=null){
            modelAndView.addObject("maTecher",maTeacher);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
