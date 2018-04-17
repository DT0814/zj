package com.xawl.zj.dao;

import com.xawl.zj.pojo.TbPaperBlank;
import com.xawl.zj.pojo.TbPaperBlankExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPaperBlankMapper {
    int countByExample(TbPaperBlankExample example);

    int deleteByExample(TbPaperBlankExample example);

    int deleteByPrimaryKey(Integer pabid);

    int insert(TbPaperBlank record);

    int insertSelective(TbPaperBlank record);

    List<TbPaperBlank> selectByExample(TbPaperBlankExample example);

    TbPaperBlank selectByPrimaryKey(Integer pabid);

    int updateByExampleSelective(@Param( "record" ) TbPaperBlank record, @Param( "example" ) TbPaperBlankExample example);

    int updateByExample(@Param( "record" ) TbPaperBlank record, @Param( "example" ) TbPaperBlankExample example);

    int updateByPrimaryKeySelective(TbPaperBlank record);

    int updateByPrimaryKey(TbPaperBlank record);
}