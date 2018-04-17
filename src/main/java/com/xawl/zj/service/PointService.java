package com.xawl.zj.service;

import com.xawl.zj.dao.TbPointMapper;
import com.xawl.zj.pojo.TbPoint;
import com.xawl.zj.pojo.TbPointExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointService {
    @Autowired
    private TbPointMapper tbPointMapper;

    public List<TbPoint> findAll() {
        TbPointExample example = new TbPointExample();
        List<TbPoint> tbStudents = tbPointMapper.selectByExample(example);
        return tbStudents;
    }

    public int insert(TbPoint point) {
        return tbPointMapper.insert(point);
    }

    public int update(TbPoint point) {
        return tbPointMapper.updateByPrimaryKeySelective(point);
    }

    public int delete(TbPoint point) {
        return tbPointMapper.deleteByPrimaryKey(point.getPid());
    }

}
