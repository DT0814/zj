package com.xawl.zj.service;

import com.xawl.zj.dao.TbStudentScoreMapper;
import com.xawl.zj.pojo.TbStudentScore;
import com.xawl.zj.pojo.TbStudentScoreExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentScoreService {
    @Autowired
    private TbStudentScoreMapper tbStudentScoreMapper;

    public TbStudentScore selectByPaid(Integer paid, String snum) {
        TbStudentScoreExample tbStudentScoreExample = new TbStudentScoreExample();
        tbStudentScoreExample.createCriteria().andPaidEqualTo(paid).andSnumEqualTo(snum);
        List<TbStudentScore> tbStudentScores = tbStudentScoreMapper.selectByExample(tbStudentScoreExample);
        if ( tbStudentScores != null && tbStudentScores.size() > 0 ) {
            return tbStudentScores.get(0);
        }
        return null;
    }

    public void insert(TbStudentScore tbStudentScore) {
        tbStudentScoreMapper.insert(tbStudentScore);
    }

    public TbStudentScore selectByPaidAndSnum(Integer paid, String snum) {
        TbStudentScoreExample tbStudentScoreExample = new TbStudentScoreExample();
        tbStudentScoreExample.createCriteria().andPaidEqualTo(paid).andSnumEqualTo(snum).andSnumEqualTo(snum);
        List<TbStudentScore> tbStudentScores = tbStudentScoreMapper.selectByExample(tbStudentScoreExample);
        if ( tbStudentScores != null && tbStudentScores.size() > 0 ) {
            return tbStudentScores.get(0);
        }
        return null;
    }
}
