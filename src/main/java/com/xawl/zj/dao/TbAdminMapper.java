package com.xawl.zj.dao;

import com.xawl.zj.pojo.TbAdmin;
import com.xawl.zj.pojo.TbAdminExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbAdminMapper {
    int countByExample(TbAdminExample example);

    int deleteByExample(TbAdminExample example);

    int deleteByPrimaryKey(String aid);

    int insert(TbAdmin record);

    int insertSelective(TbAdmin record);

    List<TbAdmin> selectByExample(TbAdminExample example);

    TbAdmin selectByPrimaryKey(String aid);

    int updateByExampleSelective(@Param( "record" ) TbAdmin record, @Param( "example" ) TbAdminExample example);

    int updateByExample(@Param( "record" ) TbAdmin record, @Param( "example" ) TbAdminExample example);

    int updateByPrimaryKeySelective(TbAdmin record);

    int updateByPrimaryKey(TbAdmin record);
}