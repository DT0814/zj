package com.xawl.zj.dao;

import com.xawl.zj.pojo.TbSanswerPaperStudent;
import com.xawl.zj.pojo.TbSanswerPaperStudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSanswerPaperStudentMapper {
    int countByExample(TbSanswerPaperStudentExample example);

    int deleteByExample(TbSanswerPaperStudentExample example);

    int deleteByPrimaryKey(Integer sapaid);

    int insert(TbSanswerPaperStudent record);

    int insertSelective(TbSanswerPaperStudent record);

    List<TbSanswerPaperStudent> selectByExample(TbSanswerPaperStudentExample example);

    TbSanswerPaperStudent selectByPrimaryKey(Integer sapaid);

    int updateByExampleSelective(@Param( "record" ) TbSanswerPaperStudent record, @Param( "example" ) TbSanswerPaperStudentExample example);

    int updateByExample(@Param( "record" ) TbSanswerPaperStudent record, @Param( "example" ) TbSanswerPaperStudentExample example);

    int updateByPrimaryKeySelective(TbSanswerPaperStudent record);

    int updateByPrimaryKey(TbSanswerPaperStudent record);
}