package com.xawl.zj.dao;

import com.xawl.zj.pojo.TbPoint;
import com.xawl.zj.pojo.TbPointExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPointMapper {
    int countByExample(TbPointExample example);

    int deleteByExample(TbPointExample example);

    int deleteByPrimaryKey(Integer pid);

    int insert(TbPoint record);

    int insertSelective(TbPoint record);

    List<TbPoint> selectByExample(TbPointExample example);

    TbPoint selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param( "record" ) TbPoint record, @Param( "example" ) TbPointExample example);

    int updateByExample(@Param( "record" ) TbPoint record, @Param( "example" ) TbPointExample example);

    int updateByPrimaryKeySelective(TbPoint record);

    int updateByPrimaryKey(TbPoint record);
}