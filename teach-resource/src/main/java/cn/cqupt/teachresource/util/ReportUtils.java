package cn.cqupt.teachresource.util;

import cn.cqupt.teachresource.BaseParam.ReportResponse;
import cn.cqupt.teachresource.model.ReportTemplate;

import java.text.SimpleDateFormat;

/**
 * Created by YukunGeng on 2018/5/22.
 */
public class ReportUtils {
    public static void convertReport2(ReportTemplate reportTemplate, ReportResponse reportResponse) {
        reportResponse.setId(reportTemplate.getId());
        reportResponse.setTitle(reportTemplate.getTitle());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        reportResponse.setCreateTimeFormat(format.format(reportTemplate.getCreateTime()));
        reportResponse.setUpdateTimeFormat(format.format(reportTemplate.getUpdateTime()));
    }
}
