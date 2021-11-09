package com.taimei.model;

/**
 * @Author: Colin Feng
 * @Date: 2020/11/10
 * @Description:
 */
public class ServiceVO {

    private String id;
    private String name;

    public ServiceVO() {
    }

    public ServiceVO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ServiceVO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServiceVO)) return false;

        ServiceVO serviceVO = (ServiceVO) o;

        if (!id.equals(serviceVO.id)) return false;
        return name.equals(serviceVO.name);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
