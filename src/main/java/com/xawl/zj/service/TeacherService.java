package com.xawl.zj.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xawl.zj.dao.TbTeacherMapper;
import com.xawl.zj.pojo.TbTeacher;
import com.xawl.zj.pojo.TbTeacherExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void insert(TbTeacher teacher) {
        tbTeacherMapper.insert(teacher);
    }

    public PageInfo<TbTeacher> findAll(Integer page, Integer num) {
        PageHelper.startPage(page, num);
        TbTeacherExample tbTeacherExample = new TbTeacherExample();
        List<TbTeacher> list = tbTeacherMapper.selectByExample(tbTeacherExample);
        PageInfo<TbTeacher> pageInfo = new PageInfo<TbTeacher>(list);
        return pageInfo;
    }

    public void delete(String tnum) {
        tbTeacherMapper.deleteByPrimaryKey(tnum);
    }
}
