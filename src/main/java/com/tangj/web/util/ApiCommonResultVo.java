package com.tangj.web.util;

public class ApiCommonResultVo {
	
	public ApiCommonResultVo(){
		
	}

	public ApiCommonResultVo(int code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		if (data != null) {
			this.data = data;
		}
	}
	
	public ApiCommonResultVo(Object data) {
		this.code = 0;
		this.msg = "";
		if (data != null) {
			this.data = data;
		}
	}
	
	/**
	 * 返回码
	 */
	private int code;

	/**
	 * 返回描述
	 */
	private String msg = "";

	/**
	 * 返回数据
	 */
	private Object data = new Object();

	public void setCode(int code) {
		this.code = code;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public Object getData() {
		return data;
	}
	
}
