package cn.cqupt.teachresource.mapper;

import cn.cqupt.teachresource.model.StudingTeacherNav;
import cn.cqupt.teachresource.model.StudingTeacherNavExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudingTeacherNavMapper {
    int countByExample(StudingTeacherNavExample example);

    int deleteByExample(StudingTeacherNavExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudingTeacherNav record);

    int insertSelective(StudingTeacherNav record);

    List<StudingTeacherNav> selectByExample(StudingTeacherNavExample example);

    StudingTeacherNav selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudingTeacherNav record, @Param("example") StudingTeacherNavExample example);

    int updateByExample(@Param("record") StudingTeacherNav record, @Param("example") StudingTeacherNavExample example);

    int updateByPrimaryKeySelective(StudingTeacherNav record);

    int updateByPrimaryKey(StudingTeacherNav record);
}