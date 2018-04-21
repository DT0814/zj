package com.xawl.zj.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    public PageInfo findAll(Integer page, Integer num) {
        PageHelper.startPage(page, num);
        TbStudentExample example = new TbStudentExample();
        List<TbStudent> tbStudents = tbStudentMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(tbStudents);
        return pageInfo;
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

    public List<TbStudent> findByCid(Integer cid) {
        TbStudentExample example = new TbStudentExample();
        example.createCriteria().andCidEqualTo(cid);
        List<TbStudent> tbStudents = tbStudentMapper.selectByExample(example);
        return tbStudents;
    }
}
