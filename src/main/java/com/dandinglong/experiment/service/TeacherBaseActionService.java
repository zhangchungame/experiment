package com.dandinglong.experiment.service;


import com.dandinglong.experiment.dto.MaClassInfo;
import com.dandinglong.experiment.mapper.MaClassInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class TeacherBaseActionService {
    @Autowired
    private MaClassInfoMapper maClassInfoMapper;

    /**
     * 保存班级信息
     * @param maClassInfo
     * @return
     */
    public boolean saveClassInfo(MaClassInfo maClassInfo){
        MaClassInfo record;
        if(maClassInfo.getId()>0){
            record=maClassInfoMapper.selectByPrimaryKey(maClassInfo.getId());
        }else{
            record=new MaClassInfo();
            record.setInsertTime(new Date());
        }
        record.setClassName(maClassInfo.getClassName());
        record.setGrade(maClassInfo.getGrade());
        record.setUpdateTime(new Date());
        if(maClassInfo.getId()>0){
            maClassInfoMapper.updateByPrimaryKey(record);
        }else{
            maClassInfoMapper.insert(record);
        }
        return true;
    }
    public MaClassInfo findClassInfo(int id){
        MaClassInfo maClassInfo=maClassInfoMapper.selectByPrimaryKey(id);
        return maClassInfo;
    }
}
