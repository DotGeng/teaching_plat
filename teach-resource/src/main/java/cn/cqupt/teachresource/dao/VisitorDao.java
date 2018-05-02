package cn.cqupt.teachresource.dao;

import cn.cqupt.teachresource.BaseParam.PagingResponse;
import cn.cqupt.teachresource.BaseParam.VisitorPagingData;
import cn.cqupt.teachresource.model.VisitorRecord;

/**
 * Created by YukunGeng on 2018/4/29.
 */
public interface VisitorDao {
    public void addVisitorInfo(VisitorRecord visitorRecord);

    PagingResponse getVisitorList(VisitorPagingData visitorPagingData);
}
