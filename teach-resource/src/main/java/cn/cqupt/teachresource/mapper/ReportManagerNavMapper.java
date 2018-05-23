package cn.cqupt.teachresource.mapper;

import cn.cqupt.teachresource.model.ReportManagerNav;
import cn.cqupt.teachresource.model.ReportManagerNavExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReportManagerNavMapper {
    int countByExample(ReportManagerNavExample example);

    int deleteByExample(ReportManagerNavExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ReportManagerNav record);

    int insertSelective(ReportManagerNav record);

    List<ReportManagerNav> selectByExample(ReportManagerNavExample example);

    ReportManagerNav selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ReportManagerNav record, @Param("example") ReportManagerNavExample example);

    int updateByExample(@Param("record") ReportManagerNav record, @Param("example") ReportManagerNavExample example);

    int updateByPrimaryKeySelective(ReportManagerNav record);

    int updateByPrimaryKey(ReportManagerNav record);
}