package cn.cqupt.teachresource.controller;

import cn.cqupt.teachresource.BaseParam.PagingResponse;
import cn.cqupt.teachresource.BaseParam.ReportPagingData;
import cn.cqupt.teachresource.BaseParam.ReportTemplateCustom;
import cn.cqupt.teachresource.BashStatus.ResponseStatus;
import cn.cqupt.teachresource.model.ReportTemplate;
import cn.cqupt.teachresource.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by YukunGeng on 2018/5/21.
 */
@RestController
public class ExperimentReportController extends BaseController {
    @Autowired
    ReportService reportService;

    @RequestMapping(value = "/report/list", method = RequestMethod.POST)
    public PagingResponse getReportByPaing(ReportPagingData reportPagingData) {
        return reportService.getReports(reportPagingData);
    }

    @RequestMapping(value = "/report/templete/adding", method = RequestMethod.POST)
    public ResponseStatus addReportTemplete(ReportTemplateCustom reportTemplate) {
        Integer id = reportService.addReprotTemplete(reportTemplate);
        return success("ok", id);
    }
}
