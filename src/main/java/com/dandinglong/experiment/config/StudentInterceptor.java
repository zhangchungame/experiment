package com.dandinglong.experiment.config;

import com.dandinglong.experiment.dto.MaStudent;
import com.dandinglong.experiment.dto.MaTeacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class StudentInterceptor implements HandlerInterceptor {
    private Logger logger= LoggerFactory.getLogger(StudentInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse httpServletResponse, Object o) throws Exception {
        logger.info(req.getRequestURL().toString());
        HttpSession session=req.getSession();
        MaStudent maStudent=(MaStudent)session.getAttribute("maStudent");
        if(maStudent==null){
            httpServletResponse.sendRedirect("/login");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
