package com.dandinglong.experiment.util;


import com.dandinglong.experiment.dao.RespRestfulDto;

public class RespCommon {
    public static RespRestfulDto success(Object object){
        RespRestfulDto respRestfulDto =new RespRestfulDto();
        respRestfulDto.setCode("200");
        respRestfulDto.setMsg("success");
        respRestfulDto.setData(object);
        return respRestfulDto;
    }


    public static RespRestfulDto fail(Exception e){
        RespRestfulDto respRestfulDto =new RespRestfulDto();
        respRestfulDto.setCode("500");
        respRestfulDto.setMsg(e.getMessage());
        respRestfulDto.setData(null);
        return respRestfulDto;
    }
}
