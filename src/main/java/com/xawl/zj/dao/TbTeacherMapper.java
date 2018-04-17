package com.xawl.zj.dao;

import com.xawl.zj.pojo.TbTeacher;
import com.xawl.zj.pojo.TbTeacherExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbTeacherMapper {
    int countByExample(TbTeacherExample example);

    int deleteByExample(TbTeacherExample example);

    int deleteByPrimaryKey(String tnum);

    int insert(TbTeacher record);

    int insertSelective(TbTeacher record);

    List<TbTeacher> selectByExample(TbTeacherExample example);

    TbTeacher selectByPrimaryKey(String tnum);

    int updateByExampleSelective(@Param( "record" ) TbTeacher record, @Param( "example" ) TbTeacherExample example);

    int updateByExample(@Param( "record" ) TbTeacher record, @Param( "example" ) TbTeacherExample example);

    int updateByPrimaryKeySelective(TbTeacher record);

    int updateByPrimaryKey(TbTeacher record);
}