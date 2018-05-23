package cn.cqupt.teachresource.BaseParam;

import cn.cqupt.teachresource.model.ReportTemplate;

/**
 * Created by YukunGeng on 2018/5/22.
 */
public class ReportTemplateCustom extends ReportTemplate {
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
