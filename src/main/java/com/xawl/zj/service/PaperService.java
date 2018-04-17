package com.xawl.zj.service;

import com.xawl.zj.dao.TbPaperMapper;
import com.xawl.zj.pojo.TbPaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaperService {
    @Autowired
    private TbPaperMapper tbPaperMapper;

    public TbPaper selectBypid(Integer paid) {
        return tbPaperMapper.selectByPrimaryKey(paid);
    }
}
