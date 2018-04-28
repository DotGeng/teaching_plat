package cn.cqupt.teachresource.mapper;

import cn.cqupt.teachresource.model.VisitorRecord;
import cn.cqupt.teachresource.model.VisitorRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VisitorRecordMapper {
    int countByExample(VisitorRecordExample example);

    int deleteByExample(VisitorRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(VisitorRecord record);

    int insertSelective(VisitorRecord record);

    List<VisitorRecord> selectByExample(VisitorRecordExample example);

    VisitorRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VisitorRecord record, @Param("example") VisitorRecordExample example);

    int updateByExample(@Param("record") VisitorRecord record, @Param("example") VisitorRecordExample example);

    int updateByPrimaryKeySelective(VisitorRecord record);

    int updateByPrimaryKey(VisitorRecord record);
}