package cn.cqupt.teachresource.dao.Impl;

import cn.cqupt.teachresource.dao.ReportManagerNavDao;
import cn.cqupt.teachresource.mapper.ReportManagerNavMapper;
import cn.cqupt.teachresource.model.ReportManagerNav;
import cn.cqupt.teachresource.model.ReportManagerNavExample;
import cn.cqupt.teachresource.model.TeacherNav;
import cn.cqupt.teachresource.service.ReportManagerNavService;
import cn.cqupt.teachresource.util.CriteriaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by YukunGeng on 2018/5/21.
 */
@Component
public class ReportManagerNavDaoImpl implements ReportManagerNavDao {
    @Autowired
    private ReportManagerNavMapper reportManagerNavMapper;


    @Override
    public List<ReportManagerNav> getReportManagerNavs(ReportManagerNav reportManagerNav) {
        ReportManagerNavExample example = new ReportManagerNavExample();
        CriteriaUtils.getCriteria(example).andNidEqualTo(reportManagerNav.getId());
        List<ReportManagerNav> reportManagerNavs = reportManagerNavMapper.selectByExample(example);
        return reportManagerNavs;
    }
}
