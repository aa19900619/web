package com.tangj.web.vo.base;

public class BaseQueryVO {

	private int pageNum;
	
	private int pageSize;
	
	private String initStatus;

	public int getPageNum() {
		if( this.pageNum <= 0 ){
			return 1;
		}
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		if( this.pageSize <= 0 ){
			return 10;
		}
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getInitStatus() {
		return initStatus;
	}

	public void setInitStatus(String initStatus) {
		this.initStatus = initStatus;
	}
	
}
