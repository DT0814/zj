package com.xawl.zj.dao;

import com.xawl.zj.pojo.TbPaperSanswer;
import com.xawl.zj.pojo.TbPaperSanswerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPaperSanswerMapper {
    int countByExample(TbPaperSanswerExample example);

    int deleteByExample(TbPaperSanswerExample example);

    int deleteByPrimaryKey(Integer pasaid);

    int insert(TbPaperSanswer record);

    int insertSelective(TbPaperSanswer record);

    List<TbPaperSanswer> selectByExample(TbPaperSanswerExample example);

    TbPaperSanswer selectByPrimaryKey(Integer pasaid);

    int updateByExampleSelective(@Param( "record" ) TbPaperSanswer record, @Param( "example" ) TbPaperSanswerExample example);

    int updateByExample(@Param( "record" ) TbPaperSanswer record, @Param( "example" ) TbPaperSanswerExample example);

    int updateByPrimaryKeySelective(TbPaperSanswer record);

    int updateByPrimaryKey(TbPaperSanswer record);
}