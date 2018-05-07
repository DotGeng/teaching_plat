package cn.cqupt.teachresource.mapper;

import cn.cqupt.teachresource.model.StudyingMaterial;
import cn.cqupt.teachresource.model.StudyingMaterialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyingMaterialMapper {
    int countByExample(StudyingMaterialExample example);

    int deleteByExample(StudyingMaterialExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudyingMaterial record);

    int insertSelective(StudyingMaterial record);

    List<StudyingMaterial> selectByExample(StudyingMaterialExample example);

    StudyingMaterial selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudyingMaterial record, @Param("example") StudyingMaterialExample example);

    int updateByExample(@Param("record") StudyingMaterial record, @Param("example") StudyingMaterialExample example);

    int updateByPrimaryKeySelective(StudyingMaterial record);

    int updateByPrimaryKey(StudyingMaterial record);
}