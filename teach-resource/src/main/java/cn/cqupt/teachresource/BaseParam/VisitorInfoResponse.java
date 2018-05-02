package cn.cqupt.teachresource.BaseParam;

import cn.cqupt.teachresource.model.VisitorRecord;

/**
 * Created by YukunGeng on 2018/5/1.
 */
public class VisitorInfoResponse extends VisitorRecord {
    public String visitorTimeString;
    public String roleName;

    public String getVisitorTimeString() {
        return visitorTimeString;
    }

    public void setVisitorTimeString(String visitorTimeString) {
        this.visitorTimeString = visitorTimeString;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
