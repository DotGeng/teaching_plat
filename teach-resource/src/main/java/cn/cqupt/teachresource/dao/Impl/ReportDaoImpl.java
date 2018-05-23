package cn.cqupt.teachresource.dao.Impl;

import cn.cqupt.teachresource.BaseParam.PagingResponse;
import cn.cqupt.teachresource.BaseParam.ReportPagingData;
import cn.cqupt.teachresource.BaseParam.ReportResponse;
import cn.cqupt.teachresource.dao.ReportDao;
import cn.cqupt.teachresource.mapper.ReportTemplateMapper;
import cn.cqupt.teachresource.mapper.ReportTemplateMapperCustom;
import cn.cqupt.teachresource.model.ReportTemplate;
import cn.cqupt.teachresource.model.ReportTemplateExample;
import cn.cqupt.teachresource.util.CriteriaUtils;
import cn.cqupt.teachresource.util.ReportUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by YukunGeng on 2018/5/21.
 */
@Component
public class ReportDaoImpl implements ReportDao {
    @Autowired
    private ReportTemplateMapperCustom reportTemplateMapperCustom;

    @Override
    public PagingResponse getReportsByPaging(ReportPagingData reportPagingData) {
        ReportTemplateExample example = new ReportTemplateExample();
        ReportTemplateExample.Criteria criteria = CriteriaUtils.getCriteria(example);
        if (reportPagingData.getTitle() != null && reportPagingData.getTitle() != "") {
            criteria.andTitleLike("%" + reportPagingData.getTitle() + "%");
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        if (reportPagingData.getCreateTimeEnd() != null && reportPagingData.getCreateTimeEnd() != "") {

            try {
                criteria.andCreateTimeGreaterThan(format.parse(reportPagingData.getCreateTimeBegin()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (reportPagingData.getCreateTimeEnd() != null && reportPagingData.getCreateTimeEnd() != "") {
            try {
                format.parse(reportPagingData.getCreateTimeEnd());
                Date date = (new SimpleDateFormat("yyyy-MM-dd")).parse(reportPagingData.getCreateTimeEnd());
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                cal.add(Calendar.DATE, 1);
                date = cal.getTime();
                criteria.andCreateTimeLessThan(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        List<ReportTemplate> reportTemplates = reportTemplateMapperCustom.selectByExample(example);
        List<ReportTemplate> reportTemplates1 = new ArrayList<>();
        if (reportTemplates != null && reportTemplates.size() > 0) {
            for (ReportTemplate rpt : reportTemplates) {
                ReportResponse rr = new ReportResponse();
                ReportUtils.convertReport2(rpt, rr);
                reportTemplates1.add(rr);
            }
        }

        int count = reportTemplateMapperCustom.countByExample(example);
        PagingResponse pr = new PagingResponse();
        pr.setRows(reportTemplates1);
        pr.setTotal(count);
        return pr;
    }

    @Override
    public int addReportTemplete(ReportTemplate reportTemplate) {
        int id = reportTemplateMapperCustom.insertSelective(reportTemplate);
        return id;
    }
}
