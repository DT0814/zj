package com.xawl.zj.service;

import com.xawl.zj.dao.TbSanswerPaperStudentMapper;
import com.xawl.zj.pojo.TbSanswerPaperStudent;
import com.xawl.zj.pojo.TbSanswerPaperStudentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanswerPaperStudentService {
    @Autowired
    private TbSanswerPaperStudentMapper tbSanswerPaperStudentMapper;

    public void insert(TbSanswerPaperStudent tbSanswerPaperStudent) {
        tbSanswerPaperStudentMapper.insert(tbSanswerPaperStudent);
    }

    public List<TbSanswerPaperStudent> findBySnumAndPaid(Integer paid, String snum) {
        TbSanswerPaperStudentExample tbSanswerPaperStudentExample = new TbSanswerPaperStudentExample();
        tbSanswerPaperStudentExample.createCriteria().andSnumEqualTo(snum).andPaidEqualTo(paid);
        return tbSanswerPaperStudentMapper.selectByExample(tbSanswerPaperStudentExample);
    }
}
