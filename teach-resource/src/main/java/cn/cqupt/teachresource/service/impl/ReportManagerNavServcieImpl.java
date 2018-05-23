package cn.cqupt.teachresource.service.impl;

import cn.cqupt.teachresource.dao.ReportManagerNavDao;
import cn.cqupt.teachresource.model.ReportManagerNav;
import cn.cqupt.teachresource.model.TeacherNav;
import cn.cqupt.teachresource.service.ReportManagerNavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YukunGeng on 2018/5/21.
 */
@Service
public class ReportManagerNavServcieImpl implements ReportManagerNavService {
    @Autowired
    private ReportManagerNavDao reportManagerNavDao;

    @Override
    public List<ReportManagerNav> getReportManagerNavs(ReportManagerNav reportManagerNav) {
        if (reportManagerNav.getId() == null) {
            reportManagerNav.setId(0);
        }
        return reportManagerNavDao.getReportManagerNavs(reportManagerNav);
    }
}
