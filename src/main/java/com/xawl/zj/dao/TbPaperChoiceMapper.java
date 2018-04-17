package com.xawl.zj.dao;

import com.xawl.zj.pojo.TbPaperChoice;
import com.xawl.zj.pojo.TbPaperChoiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPaperChoiceMapper {
    int countByExample(TbPaperChoiceExample example);

    int deleteByExample(TbPaperChoiceExample example);

    int deleteByPrimaryKey(Integer pacid);

    int insert(TbPaperChoice record);

    int insertSelective(TbPaperChoice record);

    List<TbPaperChoice> selectByExample(TbPaperChoiceExample example);

    TbPaperChoice selectByPrimaryKey(Integer pacid);

    int updateByExampleSelective(@Param( "record" ) TbPaperChoice record, @Param( "example" ) TbPaperChoiceExample example);

    int updateByExample(@Param( "record" ) TbPaperChoice record, @Param( "example" ) TbPaperChoiceExample example);

    int updateByPrimaryKeySelective(TbPaperChoice record);

    int updateByPrimaryKey(TbPaperChoice record);
}