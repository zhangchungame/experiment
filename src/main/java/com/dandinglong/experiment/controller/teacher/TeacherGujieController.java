package com.dandinglong.experiment.controller.teacher;


import com.dandinglong.experiment.dao.RespRestfulDto;
import com.dandinglong.experiment.dto.MaGujieInitData;
import com.dandinglong.experiment.service.GujieService;
import com.dandinglong.experiment.util.RespCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/teacher/gujie")
public class TeacherGujieController {

    @Autowired
    private GujieService gujieService;
    @RequestMapping(value = "initData",method = RequestMethod.GET)
    public ModelAndView initDataGet(@RequestParam(value = "classId",required = true)int classId) throws Exception {
        ModelAndView modelAndView=new ModelAndView("teacher/gujieInitData");
        modelAndView.addObject("maGujieInitData",gujieService.findInitData(classId));
        return modelAndView;
    }

    @RequestMapping(value = "initData",method = RequestMethod.POST)
    public RespRestfulDto initDataPost(@RequestBody MaGujieInitData maGujieInitData, HttpServletResponse response){

        try {
            RespRestfulDto respRestfulDto = RespCommon.success(gujieService.saveInitData(maGujieInitData));
            return respRestfulDto;
        } catch (Exception e) {
            return RespCommon.fail(e);
        }
    }

}
