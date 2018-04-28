package cn.cqupt.teachresource.BaseParam;

import cn.cqupt.teachresource.model.Article;

import java.util.List;

/**
 * Created by YukunGeng on 2018/4/23.
 */
public class PagingResponse {
    private Integer total;
    private List<Object> rows;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Object> getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
