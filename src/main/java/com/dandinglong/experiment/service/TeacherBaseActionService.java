package com.dandinglong.experiment.service;


import com.dandinglong.experiment.dao.PageInfo;
import com.dandinglong.experiment.dto.MaClassInfo;
import com.dandinglong.experiment.dto.MaStudent;
import com.dandinglong.experiment.mapper.MaClassInfoMapper;
import com.dandinglong.experiment.mapper.MaStudentMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeacherBaseActionService {
    @Autowired
    private MaClassInfoMapper maClassInfoMapper;
    @Autowired
    private MaStudentMapper maStudentMapper;

    /**
     * 保存班级信息
     *
     * @param maClassInfo
     * @return
     */
    public boolean saveClassInfo(MaClassInfo maClassInfo) {
        MaClassInfo record;
        if (maClassInfo.getId() > 0) {
            record = maClassInfoMapper.selectByPrimaryKey(maClassInfo.getId());
        } else {
            record = new MaClassInfo();
            record.setInsertTime(new Date());
        }
        record.setClassName(maClassInfo.getClassName());
        record.setGrad(maClassInfo.getGrad());
        record.setUpdateTime(new Date());
        if (maClassInfo.getId() > 0) {
            maClassInfoMapper.updateByPrimaryKey(record);
        } else {
            maClassInfoMapper.insert(record);
        }
        Example example=new Example(MaStudent.class);
        example.createCriteria().andEqualTo("classId",record.getId());
        List<MaStudent> students=maStudentMapper.selectByExample(example);
        for(MaStudent maStudent : students){
            maStudent.setGrad(record.getGrad());
            maStudent.setClassName(record.getGrad());
            maStudentMapper.updateByPrimaryKey(maStudent);
        }
        return true;
    }

    public MaClassInfo findClassInfo(int id) {
        MaClassInfo maClassInfo = maClassInfoMapper.selectByPrimaryKey(id);
        return maClassInfo;
    }

    public boolean delClassInfo(int id) throws Exception {
        MaClassInfo maClassInfo = maClassInfoMapper.selectByPrimaryKey(id);
        if (maClassInfo.getStudentNum() == 0) {
            maClassInfoMapper.deleteByPrimaryKey(id);
        } else {
            throw new Exception("请先删除班级下面的学生，才能删除班级");
        }
        return true;
    }

    public PageInfo classList(int page) {
        PageInfo pageInfo = new PageInfo();
        Example example = new Example(MaClassInfo.class);
        example.orderBy("id").desc();
        RowBounds rowBounds = new RowBounds(page - 1, 20);
        pageInfo.setList(maClassInfoMapper.selectByExampleAndRowBounds(example, rowBounds));
        pageInfo.setCurrentPage(page);
        int count = maClassInfoMapper.selectCountByExample(example);
        pageInfo.setTotalPage((int) Math.ceil((double) count / 20.0));
        return pageInfo;
    }

    public List<MaClassInfo> findAllClassInfo() {
        Example example = new Example(MaClassInfo.class);
        example.orderBy("grad").desc();
        return maClassInfoMapper.selectByExample(example);
    }


    public MaStudent findStudent(int id) {
        MaStudent maStudent = maStudentMapper.selectByPrimaryKey(id);
        return maStudent;
    }

    public boolean batchCreateStudent(List<MaStudent> list) throws Exception {
        String msg = "";
        Map<String, String> classIdMap = new HashMap<>();
        for (MaStudent maStudent : list) {
            Example example = new Example(MaStudent.class);
            example.createCriteria().andEqualTo("studentNo", maStudent.getStudentNo());
            List<MaStudent> records = maStudentMapper.selectByExample(example);
            if (records.size() > 0) {
                msg += maStudent.getStudentNo() + "已存在\r\n";
            }
        }
        if (!msg.equals("")) {
            throw new Exception(msg);
        }

        for (MaStudent maStudent : list) {
            if (classIdMap.get(String.valueOf(maStudent.getClassId())) == null) {
                classIdMap.put(String.valueOf(maStudent.getClassId()), String.valueOf(maStudent.getClassId()));
            }
            maStudentMapper.insert(maStudent);
        }
        for (String classId : classIdMap.values()) {
            int classInt = new Integer(classId);
            Example example = new Example(MaStudent.class);
            example.createCriteria().andEqualTo("classId", classInt);
            int count = maStudentMapper.selectCountByExample(example);
            MaClassInfo maClassInfo = maClassInfoMapper.selectByPrimaryKey(classInt);
            maClassInfo.setUpdateTime(new Date());
            maClassInfo.setStudentNum(classInt);
            maClassInfoMapper.updateByPrimaryKey(maClassInfo);
        }

        return true;
    }


    public PageInfo studentList(int page) {
        PageInfo pageInfo = new PageInfo();
        Example example = new Example(MaStudent.class);
        example.orderBy("id").desc();
        RowBounds rowBounds = new RowBounds(page - 1, 20);
        pageInfo.setList(maStudentMapper.selectByExampleAndRowBounds(example, rowBounds));
        pageInfo.setCurrentPage(page);
        int count = maStudentMapper.selectCountByExample(example);
        pageInfo.setTotalPage((int) Math.ceil((double) count / 20.0));
        return pageInfo;
    }

    public boolean saveStudent(MaStudent maStudent) {
        MaStudent record=maStudentMapper.selectByPrimaryKey(maStudent.getId());
        record.setPassword(maStudent.getPassword());
        record.setName(maStudent.getName());
        maStudentMapper.updateByPrimaryKey(record);
        return true;
    }

    public boolean delStudent(int id) throws Exception {
        maStudentMapper.deleteByPrimaryKey(id);
        return true;
    }
}
