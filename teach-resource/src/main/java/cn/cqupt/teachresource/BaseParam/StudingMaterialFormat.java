package cn.cqupt.teachresource.BaseParam;

import cn.cqupt.teachresource.model.StudyingMaterial;

/**
 * Created by YukunGeng on 2018/5/4.
 */
public class StudingMaterialFormat extends StudyingMaterial {
    private Integer mediaId;
    private String roleFormat;
    private String createTimeFormat;
    private String updateTimeFormat;

    public Integer getMediaId() {
        return mediaId;
    }

    public void setMediaId(Integer mediaId) {
        this.mediaId = mediaId;
    }

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

    public String getRoleFormat() {
        return roleFormat;
    }

    public void setRoleFormat(String roleFormat) {
        this.roleFormat = roleFormat;
    }
}
