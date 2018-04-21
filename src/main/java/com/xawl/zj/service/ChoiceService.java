package com.xawl.zj.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xawl.zj.dao.TbChoiceMapper;
import com.xawl.zj.pojo.ChoiceResult;
import com.xawl.zj.pojo.TbChoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChoiceService {
    @Autowired
    private TbChoiceMapper tbChoiceMapper;

    public PageInfo findAll(Integer num, Integer page) {
        PageHelper.startPage(page, num);
        List<ChoiceResult> list = tbChoiceMapper.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    public int insert(TbChoice choice) {
        return tbChoiceMapper.insert(choice);
    }

    public int update(TbChoice choice) {
        return tbChoiceMapper.updateByPrimaryKeySelective(choice);
    }

    public int delete(TbChoice choice) {
        return tbChoiceMapper.deleteByPrimaryKey(choice.getCid());
    }

    public List<TbChoice> selectByCount(Integer snum) {
        return tbChoiceMapper.selectByCount(snum);
    }

    public List<TbChoice> findChoiceRandom(Integer num, Integer did, Integer pid) {
        Map<String, Integer> map = new HashMap<>();
        map.put("num", num);
        map.put("did", did);
        map.put("pid", pid);
        return tbChoiceMapper.findChoiceRandom(map);
    }

    public List<TbChoice> selectByPidAndNum(Integer pid, Integer num) {
        Map<String, Integer> map = new HashMap<>();
        map.put("num", num);
        map.put("pid", pid);
        return tbChoiceMapper.selectByPidAndNum(map);
    }
}
