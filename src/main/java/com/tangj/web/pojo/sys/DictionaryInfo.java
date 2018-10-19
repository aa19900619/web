package com.tangj.web.pojo.sys;

import com.tangj.web.util.Constanst;

import net.sf.oval.constraint.MaxLength;
import net.sf.oval.constraint.MemberOf;
import net.sf.oval.constraint.Min;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

public class DictionaryInfo {

	public static final String ADD = "ADD";
	public static final String MODIFY = "MODIFY";
	
	@NotNull(message = "ID不能为空" , profiles = {MODIFY})
	@NotEmpty(message = "ID不能为空" , profiles = {MODIFY})
	@Min(value = 1 , message = "ID传递错误" , profiles = {MODIFY})
	private Long id;
	
	@NotNull(message = "字典编码不能为空" , profiles = {ADD,MODIFY})
	@NotEmpty(message = "字典编码不能为空" , profiles = {ADD,MODIFY})
	@MaxLength(value = 20 , message = "字典编码最大长度为20个字符" , profiles = {ADD,MODIFY})
	private String dicCode;
	
	@NotNull(message = "字典值不能为空" , profiles = {ADD,MODIFY})
	@NotEmpty(message = "字典值不能为空" , profiles = {ADD,MODIFY})
	@MaxLength(value = 20 , message = "字典值最大长度为20个字符" , profiles = {ADD,MODIFY})
	private String dicVal;
	
	@NotNull(message = "状态不能为空" , profiles = {ADD,MODIFY})
	@NotEmpty(message = "状态不能为空" , profiles = {ADD,MODIFY})
	@MemberOf(value = { Constanst.STATUS_YX_STRING , Constanst.STATUS_WX_STRING } , message = "状态值错误" , profiles = {ADD , MODIFY})
	private int status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDicCode() {
		return dicCode;
	}

	public void setDicCode(String dicCode) {
		this.dicCode = dicCode;
	}

	public String getDicVal() {
		return dicVal;
	}

	public void setDicVal(String dicVal) {
		this.dicVal = dicVal;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
