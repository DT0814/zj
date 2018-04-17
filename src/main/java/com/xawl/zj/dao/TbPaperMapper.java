package com.xawl.zj.dao;

import com.xawl.zj.pojo.TbPaper;
import com.xawl.zj.pojo.TbPaperExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbPaperMapper {
    int countByExample(TbPaperExample example);

    int deleteByExample(TbPaperExample example);

    int deleteByPrimaryKey(Integer paid);

    int insert(TbPaper record);

    int insertSelective(TbPaper record);

    List<TbPaper> selectByExample(TbPaperExample example);

    TbPaper selectByPrimaryKey(Integer paid);

    int updateByExampleSelective(@Param( "record" ) TbPaper record, @Param( "example" ) TbPaperExample example);

    int updateByExample(@Param( "record" ) TbPaper record, @Param( "example" ) TbPaperExample example);

    int updateByPrimaryKeySelective(TbPaper record);

    int updateByPrimaryKey(TbPaper record);
}