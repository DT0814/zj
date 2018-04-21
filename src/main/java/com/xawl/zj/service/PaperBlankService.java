package com.xawl.zj.service;

import com.xawl.zj.dao.TbPaperBlankMapper;
import com.xawl.zj.pojo.TbPaperBlank;
import com.xawl.zj.pojo.TbPaperBlankExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperBlankService {
    @Autowired
    private TbPaperBlankMapper tbPaperBlankMapper;

    public void insert(TbPaperBlank tbPaperBlank) {
        tbPaperBlankMapper.insert(tbPaperBlank);
    }

    public void deleteByPaid(Integer paid) {
        TbPaperBlankExample tbPaperBlankExample = new TbPaperBlankExample();
        tbPaperBlankExample.createCriteria().andPaidEqualTo(paid);
        tbPaperBlankMapper.deleteByExample(tbPaperBlankExample);
    }

    public List<TbPaperBlank> selectByPaid(Integer paid) {
        TbPaperBlankExample tbPaperBlankExample = new TbPaperBlankExample();
        tbPaperBlankExample.createCriteria().andPaidEqualTo(paid);
        return tbPaperBlankMapper.selectByExample(tbPaperBlankExample);
    }
}
