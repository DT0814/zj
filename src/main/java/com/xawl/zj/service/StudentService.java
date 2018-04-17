package com.xawl.zj.service;

import com.xawl.zj.dao.TbStudentMapper;
import com.xawl.zj.pojo.TbStudent;
import com.xawl.zj.pojo.TbStudentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private TbStudentMapper tbStudentMapper;

    public List<TbStudent> findAll() {
        TbStudentExample example = new TbStudentExample();
        List<TbStudent> tbStudents = tbStudentMapper.selectByExample(example);
        return tbStudents;
    }

    public int insert(TbStudent student) {
        return tbStudentMapper.insert(student);
    }

    public int update(TbStudent student) {
        return tbStudentMapper.updateByPrimaryKeySelective(student);
    }

    public int delete(TbStudent student) {
        return tbStudentMapper.deleteByPrimaryKey(student.getSnum());
    }

    public TbStudent findBySnum(String sum) {
        TbStudent student = tbStudentMapper.selectByPrimaryKey(sum);
        return student;
    }
}
