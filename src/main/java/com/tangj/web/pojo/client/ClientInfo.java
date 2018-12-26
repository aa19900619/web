package com.tangj.web.pojo.client;

import com.tangj.web.pojo.base.BaseInfo;

import net.sf.oval.constraint.MaxLength;
import net.sf.oval.constraint.Min;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

public class ClientInfo extends BaseInfo{
	public static final String ADD = "ADD";
	public static final String MODIFY = "MODIFY";
	
	@NotNull(message = "ID不能为空" , profiles = {MODIFY})
	@NotEmpty(message = "ID不能为空" , profiles = {MODIFY})
	@Min(value = 1 , message = "ID格式错误" , profiles = {MODIFY})
	private Long id;
	
	@NotNull(message = "商行名称不能为空" , profiles = {ADD,MODIFY})
	@NotEmpty(message = "商行名称不能为空" , profiles = {ADD,MODIFY})
	@MaxLength(value = 150 , message = "商行名称不能为空最大长度为150个字符" , profiles = {ADD,MODIFY})
	private String name;
	
	private String nameInitial;

	@MaxLength(value = 30 , message = "联系人最大长度为30个字符" , profiles = {ADD,MODIFY})
	private String linkName;
	
	@MaxLength(value = 30 , message = "联系电话最大长度为30个字符" , profiles = {ADD,MODIFY})
	private String linkTelPhone;
	
	@MaxLength(value = 30 , message = "职务最大长度为30个字符" , profiles = {ADD,MODIFY})
	private String linkPosition;
	
	@NotNull(message = "线路不能为空" , profiles = {MODIFY})
	@NotEmpty(message = "线路不能为空" , profiles = {MODIFY})
	@Min(value = 1 , message = "线路格式错误" , profiles = {MODIFY})
	private Long lines;
	
	@MaxLength(value = 150 , message = "地址最大长度为150个字符" , profiles = {ADD,MODIFY})
	private String address;
	
	@MaxLength(value = 255 , message = "地址最大长度为150个字符" , profiles = {ADD,MODIFY})
	private String remark;
	
	private Integer status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameInitial() {
		return nameInitial;
	}

	public void setNameInitial(String nameInitial) {
		this.nameInitial = nameInitial;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getLinkTelPhone() {
		return linkTelPhone;
	}

	public void setLinkTelPhone(String linkTelPhone) {
		this.linkTelPhone = linkTelPhone;
	}

	public String getLinkPosition() {
		return linkPosition;
	}

	public void setLinkPosition(String linkPosition) {
		this.linkPosition = linkPosition;
	}

	public Long getLines() {
		return lines;
	}

	public void setLines(Long lines) {
		this.lines = lines;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
