package cn.cqupt.teachresource.BaseParam;

import cn.cqupt.teachresource.model.Student;

/**
 * Created by YukunGeng on 2018/5/8.
 */
public class StudentPagingData extends Student {
    private Integer page;
    private Integer rows;
    private String sort;
    private String order;


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
}