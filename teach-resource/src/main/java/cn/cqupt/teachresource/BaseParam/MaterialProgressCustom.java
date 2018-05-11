package cn.cqupt.teachresource.BaseParam;

import cn.cqupt.teachresource.model.StudyingMateriaProgress;

/**
 * Created by YukunGeng on 2018/5/7.
 */
public class MaterialProgressCustom extends StudyingMateriaProgress {
    private String createTimeFormat;
    private String updateTimeFormat;
    private String mediaTitle;

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

    public String getMediaTitle() {
        return mediaTitle;
    }

    public void setMediaTitle(String mediaTitle) {
        this.mediaTitle = mediaTitle;
    }
}
