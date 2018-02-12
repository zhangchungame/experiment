package com.dandinglong.experiment.service;

import com.dandinglong.experiment.dto.MaStudent;
import com.dandinglong.experiment.dto.MaTeacher;
import com.dandinglong.experiment.mapper.MaStudentMapper;
import com.dandinglong.experiment.mapper.MaTeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class LoginService {
    @Autowired
    private MaTeacherMapper maTeacherMapper;
    @Autowired
    private MaStudentMapper maStudentMapper;
    public MaTeacher teacherLogin(String account,String password) throws Exception {
        Example example=new Example(MaTeacher.class);
        example.createCriteria().andEqualTo("account",account).andEqualTo("password",password);
        List<MaTeacher> t= maTeacherMapper.selectByExample(example);
        if(t.size()!=1){
            throw new Exception("帐号密码错误");
        }
        MaTeacher record=t.get(0);
        record.setLastLoginTime(new Date());
        maTeacherMapper.updateByPrimaryKey(record);
        return t.get(0);
    }


    public MaStudent studentLogin(String account,String password) throws Exception {
        Example example=new Example(MaStudent.class);
        example.createCriteria().andEqualTo("studentNo",account).andEqualTo("password",password);
        List<MaStudent> t= maStudentMapper.selectByExample(example);
        if(t.size()!=1){
            throw new Exception("帐号密码错误");
        }
        MaStudent record=t.get(0);
        record.setLastLoginTime(new Date());
        maStudentMapper.updateByPrimaryKey(record);
        return t.get(0);
    }
}
