package com.xawl.zj.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xawl.zj.dao.TbBlankMapper;
import com.xawl.zj.pojo.BlankResult;
import com.xawl.zj.pojo.TbBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlankService {
    @Autowired
    private TbBlankMapper tbBlankMapper;

    public PageInfo findAll(Integer num, Integer page) {
        PageHelper.startPage(page, num);
        List<BlankResult> list = tbBlankMapper.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    public int insert(TbBlank blank) {
        return tbBlankMapper.insert(blank);
    }

    public int update(TbBlank blank) {
        return tbBlankMapper.updateByPrimaryKeySelective(blank);
    }

    public int delete(TbBlank blank) {
        return tbBlankMapper.deleteByPrimaryKey(blank.getBid());
    }

    public List<TbBlank> selectByCount(Integer bnum) {
        return tbBlankMapper.selectByCount(bnum);
    }
}
