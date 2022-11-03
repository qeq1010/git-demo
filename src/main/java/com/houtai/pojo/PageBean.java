package com.houtai.pojo;

import java.util.List;

/**
 * 完成分页查询的JavaBean
 */
public class PageBean<T> {

    //当前页数据 (这里用泛型)
    private List<T> rows;

    //总记录数
    private int totalCount;


    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
