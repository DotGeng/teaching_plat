package cn.cqupt.teachresource.service;

import cn.cqupt.teachresource.BaseParam.PagingResponse;
import cn.cqupt.teachresource.BaseParam.ReportPagingData;
import cn.cqupt.teachresource.BaseParam.ReportTemplateCustom;
import cn.cqupt.teachresource.model.ReportTemplate;

import java.util.List;

/**
 * Created by YukunGeng on 2018/5/21.
 */
public interface ReportService {
    PagingResponse getReports(ReportPagingData reportPagingData);

    int addReprotTemplete(ReportTemplateCustom reportTemplate);
}
