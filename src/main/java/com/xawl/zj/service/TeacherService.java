package com.xawl.zj.service;

import com.xawl.zj.dao.TbTeacherMapper;
import com.xawl.zj.pojo.TbTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    private TbTeacherMapper tbTeacherMapper;

    public TbTeacher selectByTnum(String tnum) {
        return tbTeacherMapper.selectByPrimaryKey(tnum);
    }

    public TbTeacher update(TbTeacher teacher) {
        int i = tbTeacherMapper.updateByPrimaryKeySelective(teacher);
        return tbTeacherMapper.selectByPrimaryKey(teacher.getTnum());
    }
}
