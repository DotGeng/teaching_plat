package cn.cqupt.teachresource.dao.Impl;

import cn.cqupt.teachresource.BaseParam.PagingResponse;
import cn.cqupt.teachresource.BaseParam.VisitorInfoResponse;
import cn.cqupt.teachresource.BaseParam.VisitorPagingData;
import cn.cqupt.teachresource.dao.VisitorDao;
import cn.cqupt.teachresource.mapper.VisitorRecordMapper;
import cn.cqupt.teachresource.model.VisitorRecord;
import cn.cqupt.teachresource.model.VisitorRecordExample;
import cn.cqupt.teachresource.util.CriteriaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public PagingResponse getVisitorList(VisitorPagingData visitorPagingData) {
        PagingResponse pr = new PagingResponse();
        VisitorRecordExample example = new VisitorRecordExample();
        CriteriaUtils.getCriteria(example);
        pr.setTotal(visitorRecordMapper.countByExample(example));
        List<VisitorRecord> visitorRecords = visitorRecordMapper.selectByExample(example);
        List<VisitorRecord> visitorRecords2 = new ArrayList<>();
        for (VisitorRecord vr : visitorRecords) {
            VisitorInfoResponse visitorInfoResponse = new VisitorInfoResponse();
            visitor2VisitorFormat(vr, visitorInfoResponse);
            visitorRecords2.add(visitorInfoResponse);
        }
        pr.setRows(visitorRecords2);
        return pr;
    }

    private void visitor2VisitorFormat(VisitorRecord visitorRecord, VisitorInfoResponse visitorInfoResponse) {
        visitorInfoResponse.setId(visitorRecord.getId());
        visitorInfoResponse.setIp(visitorRecord.getIp());
        visitorInfoResponse.setUserName(visitorRecord.getUserName());
        if (visitorRecord.getRole() == 0) {
            visitorInfoResponse.setRoleName("学生");
        } else if (visitorRecord.getRole() == 1) {
            visitorInfoResponse.setRoleName("教师");
        } else if (visitorRecord.getRole() == 2) {
            visitorInfoResponse.setRoleName("超级管理员");
        } else {
            visitorInfoResponse.setRoleName("未知角色");
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        visitorInfoResponse.setVisitorTimeString(format.format(visitorRecord.getVisitTime()));


    }
}
