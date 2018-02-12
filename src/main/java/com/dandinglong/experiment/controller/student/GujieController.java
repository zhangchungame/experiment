package com.dandinglong.experiment.controller.student;


import com.dandinglong.experiment.dao.KpaAndMm;
import com.dandinglong.experiment.dao.RespRestfulDto;
import com.dandinglong.experiment.dto.MaGujie;
import com.dandinglong.experiment.dto.MaStudent;
import com.dandinglong.experiment.service.GujieService;
import com.dandinglong.experiment.util.RespCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/student")
public class GujieController {
    @Autowired
    private GujieService gujieService;

    @RequestMapping("")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("student/index");
        return modelAndView;
    }

    @RequestMapping("gujieIndex")
    public ModelAndView gujie(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        MaStudent maStudent = (MaStudent) session.getAttribute("maStudent");
        MaGujie maGujie = gujieService.initStep(maStudent.getStudentNo());
        ModelAndView modelAndView = new ModelAndView("student/gujie_index");
//        String stepStr;
//        switch (maGujie.getStep()){
//            case 0:
//
//        }
        modelAndView.addObject("maGujie", maGujie);
        return modelAndView;
    }

    @RequestMapping("gujie")
    public ModelAndView drag(HttpServletRequest request) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        MaStudent maStudent = (MaStudent) session.getAttribute("maStudent");
        MaGujie maGujie = gujieService.findGujie(maStudent.getStudentNo());
        switch (maGujie.getStep()) {
            case 0:
                modelAndView.setViewName("student/gujie_drag");
                break;
            case 1:
                modelAndView.setViewName("student/gujie_inputData");
                break;
            case 2:
                modelAndView.setViewName("student/gujie_jiaoyan");
                break;
            default:
                break;

        }
        modelAndView.addObject("maGujie", maGujie);
        return modelAndView;
    }

    @RequestMapping(value = "inputdata", method = RequestMethod.GET)
    public RespRestfulDto inputData(HttpServletRequest request) {
        try {
            ModelAndView modelAndView = new ModelAndView();
            HttpSession session = request.getSession();
            MaStudent maStudent = (MaStudent) session.getAttribute("maStudent");
            RespRestfulDto respRestfulDto = RespCommon.success(gujieService.inputData(maStudent.getStudentNo()));
            return respRestfulDto;
        } catch (Exception e) {
            return RespCommon.fail(e);
        }
    }

    @RequestMapping(value = "inputDataFinish",method = RequestMethod.POST)
    public RespRestfulDto inputDataFinish(@RequestBody List<KpaAndMm> list,HttpServletRequest request) {try {
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        MaStudent maStudent = (MaStudent) session.getAttribute("maStudent");
        RespRestfulDto respRestfulDto = RespCommon.success(gujieService.inputDataFinish(list,maStudent.getStudentNo()));
        return respRestfulDto;
    } catch (Exception e) {
        return RespCommon.fail(e);
    }
    }
}
