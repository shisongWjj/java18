package com.taimei.model;

import java.util.List;

/**
 * @Author: Colin Feng
 * @Date: 2020/11/10
 * @Description:
 */
public class Pages<T> {
    private List<T> data;
    private int total;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
