package cn.cqupt.teachresource.dao.Impl;

import cn.cqupt.teachresource.dao.VisitorDao;
import cn.cqupt.teachresource.mapper.VisitorRecordMapper;
import cn.cqupt.teachresource.model.VisitorRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by YukunGeng on 2018/4/29.
 */
@Component
public class VisitorDaoImpl implements VisitorDao {
    @Autowired
    private VisitorRecordMapper visitorRecordMapper;

    @Override
    public void addVisitorInfo(VisitorRecord visitorRecord) {
        visitorRecordMapper.insert(visitorRecord);
    }
}
