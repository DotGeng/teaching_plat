package cn.cqupt.teachresource.controller;

import cn.cqupt.teachresource.BaseParam.PagingResponse;
import cn.cqupt.teachresource.BaseParam.TeacherPagingData;
import cn.cqupt.teachresource.BaseParam.VisitorPagingData;
import cn.cqupt.teachresource.service.VisitorRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by YukunGeng on 2018/5/1.
 */
@RestController
public class VisitorController {
    @Autowired
    private VisitorRecordService visitorRecordService;
    @RequestMapping(value = "/visitor/list", method = RequestMethod.POST)
    public PagingResponse getVisitorInfoList(VisitorPagingData visitorPagingData) {
        return visitorRecordService.getVisitorRecord(visitorPagingData);
    }
}
