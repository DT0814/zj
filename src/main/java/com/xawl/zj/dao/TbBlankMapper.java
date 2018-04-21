package com.xawl.zj.dao;

import com.xawl.zj.pojo.BlankResult;
import com.xawl.zj.pojo.TbBlank;
import com.xawl.zj.pojo.TbBlankExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TbBlankMapper {
    int countByExample(TbBlankExample example);

    int deleteByExample(TbBlankExample example);

    int deleteByPrimaryKey(Integer bid);

    int insert(TbBlank record);

    int insertSelective(TbBlank record);

    List<TbBlank> selectByExample(TbBlankExample example);

    TbBlank selectByPrimaryKey(Integer bid);

    int updateByExampleSelective(@Param( "record" ) TbBlank record, @Param( "example" ) TbBlankExample example);

    int updateByExample(@Param( "record" ) TbBlank record, @Param( "example" ) TbBlankExample example);

    int updateByPrimaryKeySelective(TbBlank record);

    int updateByPrimaryKey(TbBlank record);

    List<TbBlank> selectByCount(Integer bnum);

    List<BlankResult> findAll();

    List<TbBlank> findBlankRandom(Map map);

    List<TbBlank> selectByPidAndNum(Map<String, Integer> map);
}