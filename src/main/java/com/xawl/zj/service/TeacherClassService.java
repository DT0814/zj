package com.xawl.zj.service;

import com.xawl.zj.dao.TbTeacherClassMapper;
import com.xawl.zj.pojo.TbTeacherClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherClassService {
    @Autowired
    private TbTeacherClassMapper tbTeacherClassMapper;

    public List<TbTeacherClass> findByTnum(String tnum) {
        List<TbTeacherClass> tbTeacherClasses = tbTeacherClassMapper.findByTnum(tnum);
        return tbTeacherClasses;
    }

    public int insert(TbTeacherClass teacherClass) {
        return tbTeacherClassMapper.insert(teacherClass);
    }

    public int delete(TbTeacherClass teacherClass) {
        return tbTeacherClassMapper.deleteByPrimaryKey(teacherClass.getTcid());
    }
}
