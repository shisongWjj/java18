package com.ss.base;



public class BasePage extends BaseRequest {

	private int pageNo = 1;// 开始页数
	private int pageSize = 20; // 分页大小
	private int start;// 开始的行数

	public BasePage() {
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
		this.limit();
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
//		if(pageSize < 1 || pageSize > 10){
//			pageSize = 5;
//		}
		this.limit();
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	private void limit() {
		this.start = (pageNo - 1) * pageSize;
	}

}
