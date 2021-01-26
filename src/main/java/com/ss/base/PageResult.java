package com.ss.base;


import java.util.List;

/**
 * @program: AutoNewConsole
 * @description: 首页弹窗配置列表
 * @author: Lu
 * @create: 2019-02-20 15:24
 **/
public class PageResult {

	private int pageNo = 1;// 开始页数
	private int pageSize = 20; // 分页大小
	private int start;// 开始的行数
	private long totalRow = 0L; // 总的行数
	private long total;
	private List<?> result; // 存放的记录

	public PageResult() {
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<?> getResult() {
		return result;
	}

	public void setResult(List<?> result) {
		this.result = result;
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

	public long getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(long totalRow) {
		this.totalRow = totalRow;
		totalPage();
	}

	private void totalPage(){
		this.total = (totalRow-1) / pageSize+1;
	}

	@Override
	public String toString() {
		return "PageResult{" +
				"pageNo=" + pageNo +
				", pageSize=" + pageSize +
				", start=" + start +
				", totalRow=" + totalRow +
				", total=" + total +
				", result=" + result +
				'}';
	}
}
