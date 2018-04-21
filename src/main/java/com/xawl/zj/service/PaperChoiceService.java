package com.xawl.zj.service;

import com.xawl.zj.dao.TbPaperChoiceMapper;
import com.xawl.zj.pojo.TbPaperChoice;
import com.xawl.zj.pojo.TbPaperChoiceExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperChoiceService {
    @Autowired
    private TbPaperChoiceMapper tbPaperChoiceMapper;

    public void insert(TbPaperChoice tbPaperChoice) {
        tbPaperChoiceMapper.insertSelective(tbPaperChoice);
    }

    public void deleteByPaid(Integer paid) {
        TbPaperChoiceExample tbPaperChoiceExample = new TbPaperChoiceExample();
        tbPaperChoiceExample.createCriteria().andPaidEqualTo(paid);
        tbPaperChoiceMapper.deleteByExample(tbPaperChoiceExample);
    }

    public List<TbPaperChoice> selectByPaid(Integer paid) {
        TbPaperChoiceExample tbPaperChoiceExample = new TbPaperChoiceExample();
        tbPaperChoiceExample.createCriteria().andPaidEqualTo(paid);
        return tbPaperChoiceMapper.selectByExample(tbPaperChoiceExample);
    }
}
