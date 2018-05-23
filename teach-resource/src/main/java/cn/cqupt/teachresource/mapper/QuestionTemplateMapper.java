package cn.cqupt.teachresource.mapper;

import cn.cqupt.teachresource.model.QuestionTemplate;
import cn.cqupt.teachresource.model.QuestionTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuestionTemplateMapper {
    int countByExample(QuestionTemplateExample example);

    int deleteByExample(QuestionTemplateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(QuestionTemplate record);

    int insertSelective(QuestionTemplate record);

    List<QuestionTemplate> selectByExample(QuestionTemplateExample example);

    QuestionTemplate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") QuestionTemplate record, @Param("example") QuestionTemplateExample example);

    int updateByExample(@Param("record") QuestionTemplate record, @Param("example") QuestionTemplateExample example);

    int updateByPrimaryKeySelective(QuestionTemplate record);

    int updateByPrimaryKey(QuestionTemplate record);
}