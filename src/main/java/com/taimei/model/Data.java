package com.taimei.model;

import java.util.List;

/**
 * @Author: Colin Feng
 * @Date: 2020/11/10
 * @Description:
 */
public class Data<T> {
    private List<T> data;
    private com.dump.model.remote.Pages<T> pages;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public com.dump.model.remote.Pages<T> getPages() {
        return pages;
    }

    public void setPages(com.dump.model.remote.Pages<T> pages) {
        this.pages = pages;
    }
}
