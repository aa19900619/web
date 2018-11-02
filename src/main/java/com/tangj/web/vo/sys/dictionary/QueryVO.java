package com.tangj.web.vo.sys.dictionary;

import com.tangj.web.vo.base.BaseQueryVO;

public class QueryVO extends BaseQueryVO{

	private String code;

	private Integer status;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
