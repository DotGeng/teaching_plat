package cn.cqupt.teachresource.service.impl;

import cn.cqupt.teachresource.BaseParam.PagingResponse;
import cn.cqupt.teachresource.BaseParam.ReportPagingData;
import cn.cqupt.teachresource.BaseParam.ReportTemplateCustom;
import cn.cqupt.teachresource.dao.ReportDao;
import cn.cqupt.teachresource.dao.TeacherDao;
import cn.cqupt.teachresource.model.ReportTemplate;
import cn.cqupt.teachresource.service.ReportService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by YukunGeng on 2018/5/21.
 */
@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportDao reportDao;
    @Autowired
    private TeacherDao teacherDao;

    @Override
    public PagingResponse getReports(ReportPagingData reportPagingData) {
        PageHelper.startPage(reportPagingData.getPage(), reportPagingData.getRows());
        PageHelper.orderBy("update_time desc");
        return reportDao.getReportsByPaging(reportPagingData);
    }

    @Override
    @Transactional
    public int addReprotTemplete(ReportTemplateCustom reportTemplate) {
        if (reportTemplate.getUserName() == null) {
            reportTemplate.setTeacherId(1);
        } else {
            reportTemplate.setTeacherId(teacherDao.getTeacherIdByTeacherName(reportTemplate.getUserName()));
        }
        reportTemplate.setCreateTime(new Date());
        reportTemplate.setUpdateTime(new Date());
        int id = reportDao.addReportTemplete(reportTemplate);
        return id;
    }
}
