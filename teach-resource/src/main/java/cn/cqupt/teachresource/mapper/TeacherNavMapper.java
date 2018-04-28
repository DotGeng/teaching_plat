package cn.cqupt.teachresource.mapper;

import cn.cqupt.teachresource.model.TeacherNav;
import cn.cqupt.teachresource.model.TeacherNavExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherNavMapper {
    int countByExample(TeacherNavExample example);

    int deleteByExample(TeacherNavExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TeacherNav record);

    int insertSelective(TeacherNav record);

    List<TeacherNav> selectByExample(TeacherNavExample example);

    TeacherNav selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TeacherNav record, @Param("example") TeacherNavExample example);

    int updateByExample(@Param("record") TeacherNav record, @Param("example") TeacherNavExample example);

    int updateByPrimaryKeySelective(TeacherNav record);

    int updateByPrimaryKey(TeacherNav record);
}