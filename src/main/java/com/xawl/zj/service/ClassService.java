package com.xawl.zj.service;

import com.xawl.zj.dao.TbClassMapper;
import com.xawl.zj.pojo.TbClass;
import com.xawl.zj.pojo.TbClassExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    private TbClassMapper classMapper;

    public List<TbClass> findAll() {
        TbClassExample tbClassExample = new TbClassExample();
        tbClassExample.createCriteria().andIsdelNotEqualTo(1);
        List<TbClass> list = classMapper.selectByExample(tbClassExample);
        return list;
    }

    public List<TbClass> AdminFindAll() {
        TbClassExample tbClassExample = new TbClassExample();
        List<TbClass> list = classMapper.selectByExample(tbClassExample);
        return list;
    }

    public int insert(TbClass tbClass) {
        return classMapper.insert(tbClass);
    }

    public int update(TbClass tbClass) {
        return classMapper.updateByPrimaryKeySelective(tbClass);
    }

    public int delete(TbClass tbClass) {
        tbClass.setIsdel(0);
        return classMapper.updateByPrimaryKeySelective(tbClass);
    }

    public TbClass findByCid(Integer cid) {
        return classMapper.selectByPrimaryKey(cid);
    }
}
