package com.ss.base;


public class BaseRequest {

	public String realName;
	public String handleUser;
	public Integer handleUserNo;

	public BaseRequest() {
	}

	public String getHandleUser() {
		return handleUser;
	}

	public void setHandleUser(String handleUser) {
		this.handleUser = handleUser;
	}

	public Integer getHandleUserNo() {
		return handleUserNo;
	}

	public void setHandleUserNo(Integer handleUserNo) {
		this.handleUserNo = handleUserNo;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	@Override
	public String toString() {
		return "BaseRequest{" +
				"realName='" + realName + '\'' +
				", handleUser='" + handleUser + '\'' +
				", handleUserNo=" + handleUserNo +
				'}';
	}
}
