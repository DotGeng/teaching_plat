package cn.cqupt.teachresource.service.impl;

import cn.cqupt.teachresource.BaseParam.PagingResponse;
import cn.cqupt.teachresource.BaseParam.VisitorPagingData;
import cn.cqupt.teachresource.dao.VisitorDao;
import cn.cqupt.teachresource.model.VisitorRecord;
import cn.cqupt.teachresource.service.VisitorRecordService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by YukunGeng on 2018/4/29.
 */
@Service
public class VisitorRecordServiceImpl implements VisitorRecordService {
    @Autowired
    private VisitorDao visitorDao;

    @Override
    public void addVisitorInfo(String ip, String userName, Integer userRole) {
        VisitorRecord vr = new VisitorRecord();
        vr.setIp(ip);
        vr.setRole(userRole);
        vr.setUserName(userName);
        vr.setVisitTime(new Date());
        visitorDao.addVisitorInfo(vr);
    }

    @Override
    public PagingResponse getVisitorRecord(VisitorPagingData visitorPagingData) {
        PageHelper.startPage(visitorPagingData.getPage(), visitorPagingData.getRows());
        PageHelper.orderBy("visit_time desc");
        PagingResponse pagingResponse = visitorDao.getVisitorList(visitorPagingData);
        return pagingResponse;
    }
}
