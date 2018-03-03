package com.dandinglong.experiment.service;


import com.alibaba.fastjson.JSON;
import com.dandinglong.experiment.dao.KpaAndMm;
import com.dandinglong.experiment.dto.MaGujie;
import com.dandinglong.experiment.dto.MaGujieInitData;
import com.dandinglong.experiment.mapper.MaGujieInitDataMapper;
import com.dandinglong.experiment.mapper.MaGujieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class GujieService {

    @Autowired
    private MaGujieMapper maGujieMapper;
    @Autowired
    private MaGujieInitDataMapper maGujieInitDataMapper;

    public MaGujie initStep(String studentNo) throws Exception {
        MaGujie maGujie;
        Example example = new Example(MaGujie.class);
        example.createCriteria().andEqualTo("studentNo", studentNo);
        List<MaGujie> list = maGujieMapper.selectByExample(example);
        if (list.size() == 0) {
            maGujie = new MaGujie();
            maGujie.setStep(0);
            maGujie.setStudentNo(studentNo);
            maGujie.setUpdateTime(new Date());
            maGujieMapper.insert(maGujie);
            return maGujie;
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            throw new Exception("数据异常");
        }
    }

    public MaGujie findGujie(String studentNo) throws Exception {
        Example example = new Example(MaGujie.class);
        example.createCriteria().andEqualTo("studentNo", studentNo);
        List<MaGujie> list = maGujieMapper.selectByExample(example);
        if (list.size() == 1) {
            return list.get(0);
        } else if (list.size() == 0) {
            return new MaGujie();
        } else {
            throw new Exception("数据异常");
        }
    }

    public boolean inputData(String studentNo) throws Exception {
        Example example = new Example(MaGujie.class);
        example.createCriteria().andEqualTo("studentNo", studentNo);
        List<MaGujie> list = maGujieMapper.selectByExample(example);
        if (list.size() == 1) {
            MaGujie maGujie = list.get(0);
            maGujie.setUpdateTime(new Date());
            maGujie.setStep(1);
            maGujieMapper.updateByPrimaryKey(maGujie);
        } else {
            throw new Exception("数据异常");
        }
        return true;
    }

    public boolean inputDataFinish(List<KpaAndMm> kpaAndMms, String studentNo) throws Exception {
        Example example = new Example(MaGujie.class);
        example.createCriteria().andEqualTo("studentNo", studentNo);
        List<MaGujie> list = maGujieMapper.selectByExample(example);
        if (list.size() == 1) {
            MaGujie maGujie = list.get(0);
            maGujie.setUpdateTime(new Date());
            maGujie.setStep(2);
            maGujie.setKpaMmJson(JSON.toJSONString(kpaAndMms));
            maGujieMapper.updateByPrimaryKey(maGujie);
        } else {
            throw new Exception("数据异常");
        }
        return true;
    }

    public MaGujieInitData findInitData(int classId) throws Exception {
        Example example = new Example(MaGujieInitData.class);
        example.createCriteria().andEqualTo("classId", classId);
        List<MaGujieInitData> list = maGujieInitDataMapper.selectByExample(example);
        if (list.size() == 0) {
            MaGujieInitData maGujieInitData = new MaGujieInitData();
            maGujieInitData.setClassId(classId);
            return maGujieInitData;
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            throw new Exception("数据异常");
        }
    }

    public boolean saveInitData(MaGujieInitData maGujieInitData) throws Exception {
        Example example = new Example(MaGujieInitData.class);
        example.createCriteria().andEqualTo("classId", maGujieInitData.getClassId());
        List<MaGujieInitData> list = maGujieInitDataMapper.selectByExample(example);
        if (list.size() == 0) {
            maGujieInitDataMapper.insert(maGujieInitData);
        } else if (list.size() == 1) {
            maGujieInitData.setId(list.get(0).getId());
            maGujieInitDataMapper.updateByPrimaryKey(maGujieInitData);
        } else {
            throw new Exception("数据异常");
        }
        return true;
    }

    public MaGujieInitData findMaGujieInitData(int classId) throws Exception {
        Example example = new Example(MaGujieInitData.class);
        example.createCriteria().andEqualTo("classId", classId);
        List<MaGujieInitData> list = maGujieInitDataMapper.selectByExample(example);
        if (list.size() == 1) {
            return list.get(0);
        } else {
            throw new Exception("数据异常");
        }

    }
}
