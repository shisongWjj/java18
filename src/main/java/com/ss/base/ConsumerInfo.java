package com.ss.base;


public class ConsumerInfo {

	
	public String memNo;// 会员编号
	public String nickName;// 昵称
	public String realName;// 真实姓名
	public String userHead;// 用户头像

	public ConsumerInfo() {
	}

	public String getMemNo() {
		return memNo;
	}

	public void setMemNo(String memNo) {
		this.memNo = memNo;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getUserHead() {
		return userHead;
	}

	public void setUserHead(String userHead) {
		this.userHead = userHead;
	}

	@Override
	public String toString() {
		return "ConsumerInfo{" +
				"memNo='" + memNo + '\'' +
				", nickName='" + nickName + '\'' +
				", realName='" + realName + '\'' +
				", userHead='" + userHead + '\'' +
				'}';
	}
}
