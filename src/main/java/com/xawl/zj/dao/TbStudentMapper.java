package com.xawl.zj.dao;

import com.xawl.zj.pojo.TbStudent;
import com.xawl.zj.pojo.TbStudentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface TbStudentMapper {
    int countByExample(TbStudentExample example);

    int deleteByExample(TbStudentExample example);

    int deleteByPrimaryKey(String snum);

    int insert(TbStudent record);

    int insertSelective(TbStudent record);

    List<TbStudent> selectByExample(TbStudentExample example);

    TbStudent selectByPrimaryKey(String snum);

    int updateByExampleSelective(@Param( "record" ) TbStudent record, @Param( "example" ) TbStudentExample example);

    int updateByExample(@Param( "record" ) TbStudent record, @Param( "example" ) TbStudentExample example);

    int updateByPrimaryKeySelective(TbStudent record);

    int updateByPrimaryKey(TbStudent record);

    int update(TbStudent student);
}