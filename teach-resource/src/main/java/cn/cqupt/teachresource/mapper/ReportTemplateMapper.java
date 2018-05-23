package cn.cqupt.teachresource.mapper;

import cn.cqupt.teachresource.model.ReportTemplate;
import cn.cqupt.teachresource.model.ReportTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportTemplateMapper {
    int countByExample(ReportTemplateExample example);

    int deleteByExample(ReportTemplateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ReportTemplate record);

    int insertSelective(ReportTemplate record);

    List<ReportTemplate> selectByExample(ReportTemplateExample example);

    ReportTemplate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ReportTemplate record, @Param("example") ReportTemplateExample example);

    int updateByExample(@Param("record") ReportTemplate record, @Param("example") ReportTemplateExample example);

    int updateByPrimaryKeySelective(ReportTemplate record);

    int updateByPrimaryKey(ReportTemplate record);
}