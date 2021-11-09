package com.taimei.model;

/**
 * @Author: Colin Feng
 * @Date: 2020/11/10
 * @Description:
 */
public class GraphQLResp<T> {
    private com.dump.model.remote.Data<T> data;

    public com.dump.model.remote.Data<T> getData() {
        return data;
    }

    public void setData(com.dump.model.remote.Data<T> data) {
        this.data = data;
    }
}


