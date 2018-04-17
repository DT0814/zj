package com.xawl.zj.service;

import com.xawl.zj.dao.TbDifficultyMapper;
import com.xawl.zj.pojo.TbDifficulty;
import com.xawl.zj.pojo.TbDifficultyExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DifficultyService {
    @Autowired
    private TbDifficultyMapper tbDifficultyMapper;

    public List<TbDifficulty> findAll() {
        TbDifficultyExample example = new TbDifficultyExample();
        List<TbDifficulty> tbDifficulties = tbDifficultyMapper.selectByExample(example);
        return tbDifficulties;
    }

    public int insert(TbDifficulty tbDifficulty) {
        int i = tbDifficultyMapper.insert(tbDifficulty);
        return i;
    }

    public int update(TbDifficulty tbDifficulty) {
        int i = tbDifficultyMapper.updateByPrimaryKeySelective(tbDifficulty);
        return i;
    }

    public int delete(TbDifficulty tbDifficulty) {
        int i = tbDifficultyMapper.deleteByPrimaryKey(tbDifficulty.getDid());
        return i;
    }
}
