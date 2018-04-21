package com.xawl.zj.service;

import com.xawl.zj.dao.TbPaperMapper;
import com.xawl.zj.pojo.TbPaper;
import com.xawl.zj.pojo.TbPaperExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperService {
    @Autowired
    private TbPaperMapper tbPaperMapper;

    public TbPaper selectByPaid(Integer paid) {
        return tbPaperMapper.selectByPrimaryKey(paid);
    }

    public List<TbPaper> findByTnum(String tnum) {
        TbPaperExample example = new TbPaperExample();
        example.createCriteria().andTnumEqualTo(tnum);
        List<TbPaper> list = tbPaperMapper.selectByExample(example);
        return list;
    }

    public void insert(TbPaper paper) {
        tbPaperMapper.insert(paper);
    }

    public void delete(Integer paid) {
        tbPaperMapper.deleteByPrimaryKey(paid);
    }

    public List<TbPaper> selectByCid(Integer cid) {
        TbPaperExample example = new TbPaperExample();
        example.createCriteria().andCidEqualTo(cid);
        List<TbPaper> list = tbPaperMapper.selectByExample(example);
        return list;
    }
}
