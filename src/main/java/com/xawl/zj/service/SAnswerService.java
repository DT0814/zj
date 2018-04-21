package com.xawl.zj.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xawl.zj.dao.TbSanswerMapper;
import com.xawl.zj.pojo.SAnswerResult;
import com.xawl.zj.pojo.TbSanswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SAnswerService {
    @Autowired
    private TbSanswerMapper tbSanswerMapper;


    public PageInfo findAll(Integer num, Integer page) {
        PageHelper.startPage(page, num);
        List<SAnswerResult> list = tbSanswerMapper.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    public int insert(TbSanswer sanswer) {
        return tbSanswerMapper.insert(sanswer);
    }

    public int update(TbSanswer sanswer) {
        return tbSanswerMapper.updateByPrimaryKeySelective(sanswer);
    }

    public int delete(TbSanswer sanswer) {
        return tbSanswerMapper.deleteByPrimaryKey(sanswer.getSaid());
    }

    public List<TbSanswer> selectByCount(Integer sanum) {
        return tbSanswerMapper.selectByCount(sanum);
    }

    public List<TbSanswer> selectByPidAndNum(Integer pid, Integer num) {
        Map<String, Integer> map = new HashMap<>();
        map.put("num", num);
        map.put("pid", pid);
        return tbSanswerMapper.selectByPidAndNum(map);
    }

    public TbSanswer findBySaid(Integer said) {
        return tbSanswerMapper.selectByPrimaryKey(said);
    }
}
