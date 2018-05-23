package cn.cqupt.teachresource.service;

import cn.cqupt.teachresource.model.ReportManagerNav;
import cn.cqupt.teachresource.model.TeacherNav;

import java.util.List;

/**
 * Created by YukunGeng on 2018/5/21.
 */
public interface ReportManagerNavService {
    public List<ReportManagerNav> getReportManagerNavs(ReportManagerNav reportManagerNav);
}
