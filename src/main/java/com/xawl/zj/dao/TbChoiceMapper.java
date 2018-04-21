package com.xawl.zj.dao;

import com.xawl.zj.pojo.ChoiceResult;
import com.xawl.zj.pojo.TbChoice;
import com.xawl.zj.pojo.TbChoiceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TbChoiceMapper {
    int countByExample(TbChoiceExample example);

    int deleteByExample(TbChoiceExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(TbChoice record);

    int insertSelective(TbChoice record);

    List<TbChoice> selectByExample(TbChoiceExample example);

    TbChoice selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param( "record" ) TbChoice record, @Param( "example" ) TbChoiceExample example);

    int updateByExample(@Param( "record" ) TbChoice record, @Param( "example" ) TbChoiceExample example);

    int updateByPrimaryKeySelective(TbChoice record);

    int updateByPrimaryKey(TbChoice record);

    List<TbChoice> selectByCount(Integer snum);

    List<ChoiceResult> findAll();

    List<TbChoice> findChoiceRandom(Map map);

    List<TbChoice> selectByPidAndNum(Map<String, Integer> map);
}