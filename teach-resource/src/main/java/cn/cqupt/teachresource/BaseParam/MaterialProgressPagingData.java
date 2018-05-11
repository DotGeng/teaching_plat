package cn.cqupt.teachresource.BaseParam;

import cn.cqupt.teachresource.model.StudyingMateriaProgress;

/**
 * Created by YukunGeng on 2018/5/7.
 */
public class MaterialProgressPagingData extends StudyingMateriaProgress {
    private Integer page;
    private Integer rows;
    private String sort;
    private String order;
    private String studentNo;
    private String createTimeBegin;
    private String createTimeEnd;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String getStudentNo() {
        return studentNo;
    }

    @Override
    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getCreateTimeBegin() {
        return createTimeBegin;
    }

    public void setCreateTimeBegin(String createTimeBegin) {
        this.createTimeBegin = createTimeBegin;
    }

    public String getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(String createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }
}
