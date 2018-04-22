package com.xawl.zj.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xawl.zj.dao.TbBlankMapper;
import com.xawl.zj.pojo.BlankResult;
import com.xawl.zj.pojo.TbBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<TbBlank> findBlankRandom(Integer num, Integer did, Integer pid) {
        Map<String, Integer> map = new HashMap<>();
        map.put("num", num);
        map.put("did", did);
        map.put("pid", pid);
        return tbBlankMapper.findBlankRandom(map);
    }

    public List<TbBlank> selectByPidAndNum(Integer pid, Integer num) {
        Map<String, Integer> map = new HashMap<>();
        map.put("num", num);
        map.put("pid", pid);
        return tbBlankMapper.selectByPidAndNum(map);
    }

    public TbBlank getOne() {
        return tbBlankMapper.getOneRandom();
    }
}
