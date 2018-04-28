package cn.cqupt.teachresource.service.impl;

import cn.cqupt.teachresource.dao.VisitorDao;
import cn.cqupt.teachresource.model.VisitorRecord;
import cn.cqupt.teachresource.service.VisitorRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by YukunGeng on 2018/4/29.
 */
@Service
public class VisitorRecordServiceImpl implements VisitorRecordService {
    @Autowired
    private VisitorDao visitorDao;

    @Override
    public void addVisitorInfo(String ip) {
        VisitorRecord vr = new VisitorRecord();
        vr.setIp(ip);
        vr.setVisitTime(new Date());
        visitorDao.addVisitorInfo(vr);
    }
}
