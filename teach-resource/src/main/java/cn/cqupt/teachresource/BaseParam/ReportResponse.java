package cn.cqupt.teachresource.BaseParam;

import cn.cqupt.teachresource.model.ReportTemplate;

/**
 * Created by YukunGeng on 2018/5/22.
 */
public class ReportResponse extends ReportTemplate {
    private String createTimeFormat;
    private String updateTimeFormat;

    public String getCreateTimeFormat() {
        return createTimeFormat;
    }

    public void setCreateTimeFormat(String createTimeFormat) {
        this.createTimeFormat = createTimeFormat;
    }

    public String getUpdateTimeFormat() {
        return updateTimeFormat;
    }

    public void setUpdateTimeFormat(String updateTimeFormat) {
        this.updateTimeFormat = updateTimeFormat;
    }
}
