package cn.cqupt.teachresource.mapper;

import cn.cqupt.teachresource.model.StudingManagerNav;
import cn.cqupt.teachresource.model.StudingManagerNavExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudingManagerNavMapper {
    int countByExample(StudingManagerNavExample example);

    int deleteByExample(StudingManagerNavExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudingManagerNav record);

    int insertSelective(StudingManagerNav record);

    List<StudingManagerNav> selectByExample(StudingManagerNavExample example);

    StudingManagerNav selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudingManagerNav record, @Param("example") StudingManagerNavExample example);

    int updateByExample(@Param("record") StudingManagerNav record, @Param("example") StudingManagerNavExample example);

    int updateByPrimaryKeySelective(StudingManagerNav record);

    int updateByPrimaryKey(StudingManagerNav record);
}