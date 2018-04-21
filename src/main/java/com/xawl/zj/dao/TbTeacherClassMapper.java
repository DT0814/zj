package com.xawl.zj.dao;

import com.xawl.zj.pojo.TbTeacherClass;
import com.xawl.zj.pojo.TbTeacherClassExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbTeacherClassMapper {
    int countByExample(TbTeacherClassExample example);

    int deleteByExample(TbTeacherClassExample example);

    int deleteByPrimaryKey(Integer tcid);

    int insert(TbTeacherClass record);

    int insertSelective(TbTeacherClass record);

    List<TbTeacherClass> selectByExample(TbTeacherClassExample example);

    TbTeacherClass selectByPrimaryKey(Integer tcid);

    int updateByExampleSelective(@Param( "record" ) TbTeacherClass record, @Param( "example" ) TbTeacherClassExample example);

    int updateByExample(@Param( "record" ) TbTeacherClass record, @Param( "example" ) TbTeacherClassExample example);

    int updateByPrimaryKeySelective(TbTeacherClass record);

    int updateByPrimaryKey(TbTeacherClass record);

    List<TbTeacherClass> findByTnum(String tnum);
}