package cn.cqupt.teachresource.mapper;

import cn.cqupt.teachresource.model.ManagerNav;
import cn.cqupt.teachresource.model.ManagerNavExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerNavMapper {
    int countByExample(ManagerNavExample example);

    int deleteByExample(ManagerNavExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ManagerNav record);

    int insertSelective(ManagerNav record);

    List<ManagerNav> selectByExample(ManagerNavExample example);

    ManagerNav selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ManagerNav record, @Param("example") ManagerNavExample example);

    int updateByExample(@Param("record") ManagerNav record, @Param("example") ManagerNavExample example);

    int updateByPrimaryKeySelective(ManagerNav record);

    int updateByPrimaryKey(ManagerNav record);
}