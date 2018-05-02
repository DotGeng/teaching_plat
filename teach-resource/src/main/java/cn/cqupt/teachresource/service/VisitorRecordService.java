package cn.cqupt.teachresource.service;

import cn.cqupt.teachresource.BaseParam.PagingResponse;
import cn.cqupt.teachresource.BaseParam.VisitorPagingData;

/**
 * Created by YukunGeng on 2018/4/29.
 */
public interface VisitorRecordService {
    // 记录用户的访问信息
    public void addVisitorInfo(String ip, String userName, Integer userRole);

    // 得到用户的所用访问信息
    public PagingResponse getVisitorRecord(VisitorPagingData visitorPagingData);
}
