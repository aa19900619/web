package com.tangj.web.pojo.base;

import java.util.Date;

public class BaseInfo {

	private Long createUserId;
	
	private String userName;

	private Date createTime;

	private Long updateUserId;
	
	private String upUserName;

	private Date updateTime;

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Long updateUserId) {
		this.updateUserId = updateUserId;
	}

	public String getUpUserName() {
		return upUserName;
	}

	public void setUpUserName(String upUserName) {
		this.upUserName = upUserName;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
