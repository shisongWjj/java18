package com.autoyol.api.vo;

public class VirtualMemInfo {
    private String virtualNo;
    private String memNo;
    private String openId;
    private String unionId;
    private String headUrl;
    private String nickName;
    private String phoneNo;
    private String isNormal;
    private String token;

    public String getVirtualNo() {
        return virtualNo;
    }

    public void setVirtualNo(String virtualNo) {
        this.virtualNo = virtualNo;
    }

    public String getMemNo() {
        return memNo;
    }

    public void setMemNo(String memNo) {
        this.memNo = memNo;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getIsNormal() {
        return isNormal;
    }

    public void setIsNormal(String isNormal) {
        this.isNormal = isNormal;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "VirtualMemInfo{" +
                "virtualNo='" + virtualNo + '\'' +
                ", memNo='" + memNo + '\'' +
                ", openId='" + openId + '\'' +
                ", unionId='" + unionId + '\'' +
                ", headUrl='" + headUrl + '\'' +
                ", nickName='" + nickName + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", isNormal='" + isNormal + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
