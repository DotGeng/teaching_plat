package cn.cqupt.teachresource.mapper;

import cn.cqupt.teachresource.model.StudyingMateriaProgress;
import cn.cqupt.teachresource.model.StudyingMateriaProgressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudyingMateriaProgressMapper {
    int countByExample(StudyingMateriaProgressExample example);

    int deleteByExample(StudyingMateriaProgressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudyingMateriaProgress record);

    int insertSelective(StudyingMateriaProgress record);

    List<StudyingMateriaProgress> selectByExample(StudyingMateriaProgressExample example);

    StudyingMateriaProgress selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudyingMateriaProgress record, @Param("example") StudyingMateriaProgressExample example);

    int updateByExample(@Param("record") StudyingMateriaProgress record, @Param("example") StudyingMateriaProgressExample example);

    int updateByPrimaryKeySelective(StudyingMateriaProgress record);

    int updateByPrimaryKey(StudyingMateriaProgress record);
}