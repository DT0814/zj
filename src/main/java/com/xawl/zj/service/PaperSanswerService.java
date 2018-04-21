package com.xawl.zj.service;

import com.xawl.zj.dao.TbPaperSanswerMapper;
import com.xawl.zj.pojo.TbPaperSanswer;
import com.xawl.zj.pojo.TbPaperSanswerExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperSanswerService {
    @Autowired
    private TbPaperSanswerMapper tbPaperSanswerMapper;

    public void insert(TbPaperSanswer tbPaperSanswer) {
        tbPaperSanswerMapper.insert(tbPaperSanswer);
    }

    public void deleteByPaid(Integer paid) {
        TbPaperSanswerExample tbPaperSanswerExample = new TbPaperSanswerExample();
        tbPaperSanswerExample.createCriteria().andPaidEqualTo(paid);
        tbPaperSanswerMapper.deleteByExample(tbPaperSanswerExample);
    }

    public List<TbPaperSanswer> selectByPaid(Integer paid) {
        TbPaperSanswerExample tbPaperSanswerExample = new TbPaperSanswerExample();
        tbPaperSanswerExample.createCriteria().andPaidEqualTo(paid);
        return tbPaperSanswerMapper.selectByExample(tbPaperSanswerExample);
    }
}
