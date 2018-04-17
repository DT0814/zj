package com.xawl.zj.dao;

import com.xawl.zj.pojo.TbClass;
import com.xawl.zj.pojo.TbClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbClassMapper {
    int countByExample(TbClassExample example);

    int deleteByExample(TbClassExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(TbClass record);

    int insertSelective(TbClass record);

    List<TbClass> selectByExample(TbClassExample example);

    TbClass selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param( "record" ) TbClass record, @Param( "example" ) TbClassExample example);

    int updateByExample(@Param( "record" ) TbClass record, @Param( "example" ) TbClassExample example);

    int updateByPrimaryKeySelective(TbClass record);

    int updateByPrimaryKey(TbClass record);
}