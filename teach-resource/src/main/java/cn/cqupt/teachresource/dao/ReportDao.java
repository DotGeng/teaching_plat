package cn.cqupt.teachresource.dao;

import cn.cqupt.teachresource.BaseParam.PagingResponse;
import cn.cqupt.teachresource.BaseParam.ReportPagingData;
import cn.cqupt.teachresource.model.ReportTemplate;

import java.util.List;

/**
 * Created by YukunGeng on 2018/5/21.
 */
public interface ReportDao {
    PagingResponse getReportsByPaging(ReportPagingData reportPagingData);

    int addReportTemplete(ReportTemplate reportTemplate);
}
