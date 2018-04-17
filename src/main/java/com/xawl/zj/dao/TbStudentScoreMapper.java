package com.xawl.zj.dao;

import com.xawl.zj.pojo.TbStudentScore;
import com.xawl.zj.pojo.TbStudentScoreExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbStudentScoreMapper {
    int countByExample(TbStudentScoreExample example);

    int deleteByExample(TbStudentScoreExample example);

    int deleteByPrimaryKey(Integer ssid);

    int insert(TbStudentScore record);

    int insertSelective(TbStudentScore record);

    List<TbStudentScore> selectByExample(TbStudentScoreExample example);

    TbStudentScore selectByPrimaryKey(Integer ssid);

    int updateByExampleSelective(@Param( "record" ) TbStudentScore record, @Param( "example" ) TbStudentScoreExample example);

    int updateByExample(@Param( "record" ) TbStudentScore record, @Param( "example" ) TbStudentScoreExample example);

    int updateByPrimaryKeySelective(TbStudentScore record);

    int updateByPrimaryKey(TbStudentScore record);
}