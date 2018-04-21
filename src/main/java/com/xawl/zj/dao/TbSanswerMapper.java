package com.xawl.zj.dao;

import com.xawl.zj.pojo.SAnswerResult;
import com.xawl.zj.pojo.TbSanswer;
import com.xawl.zj.pojo.TbSanswerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TbSanswerMapper {
    int countByExample(TbSanswerExample example);

    int deleteByExample(TbSanswerExample example);

    int deleteByPrimaryKey(Integer said);

    int insert(TbSanswer record);

    int insertSelective(TbSanswer record);

    List<TbSanswer> selectByExample(TbSanswerExample example);

    TbSanswer selectByPrimaryKey(Integer said);

    int updateByExampleSelective(@Param( "record" ) TbSanswer record, @Param( "example" ) TbSanswerExample example);

    int updateByExample(@Param( "record" ) TbSanswer record, @Param( "example" ) TbSanswerExample example);

    int updateByPrimaryKeySelective(TbSanswer record);

    int updateByPrimaryKey(TbSanswer record);

    List<TbSanswer> selectByCount(Integer sanum);

    List<SAnswerResult> findAll();

    List<TbSanswer> selectByPidAndNum(Map<String, Integer> map);
}