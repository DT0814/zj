package com.xawl.zj.dao;

import com.xawl.zj.pojo.TbDifficulty;
import com.xawl.zj.pojo.TbDifficultyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbDifficultyMapper {
    int countByExample(TbDifficultyExample example);

    int deleteByExample(TbDifficultyExample example);

    int deleteByPrimaryKey(Integer did);

    int insert(TbDifficulty record);

    int insertSelective(TbDifficulty record);

    List<TbDifficulty> selectByExample(TbDifficultyExample example);

    TbDifficulty selectByPrimaryKey(Integer did);

    int updateByExampleSelective(@Param( "record" ) TbDifficulty record, @Param( "example" ) TbDifficultyExample example);

    int updateByExample(@Param( "record" ) TbDifficulty record, @Param( "example" ) TbDifficultyExample example);

    int updateByPrimaryKeySelective(TbDifficulty record);

    int updateByPrimaryKey(TbDifficulty record);
}