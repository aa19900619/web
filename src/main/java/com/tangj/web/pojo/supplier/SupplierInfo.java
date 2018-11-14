package com.tangj.web.pojo.supplier;

import com.tangj.web.oval.TelephoneCheckImpl;
import com.tangj.web.pojo.base.BaseInfo;

import net.sf.oval.constraint.CheckWith;
import net.sf.oval.constraint.Max;
import net.sf.oval.constraint.MaxLength;
import net.sf.oval.constraint.Min;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

public class SupplierInfo extends BaseInfo{

	public static final String ADD = "ADD";
	public static final String MODIFY = "MODIFY";
	
	@NotNull(message = "ID不能为空" , profiles = {MODIFY})
	@NotEmpty(message = "ID不能为空" , profiles = {MODIFY})
	@Min(value = 1 , message = "ID数据个事错误" , profiles = {MODIFY})
	private Long id;
	
	@NotNull(message = "供应商名称不能为空" , profiles = {ADD,MODIFY})
	@NotEmpty(message = "供应商名称不能为空" , profiles = {ADD,MODIFY})
	@MaxLength(value = 150 , message = "供应商名称最大长度为150个字符" , profiles = {ADD,MODIFY})
	private String name;
	
	@MaxLength(value = 20 , message = "联系人名字最大长度为20个字符" , profiles = {ADD,MODIFY})
	private String linkName;
	
	@CheckWith(value = TelephoneCheckImpl.class , message = "联系人电话格式错误" , profiles = {ADD,MODIFY})
	@MaxLength(value = 11 , message = "联系人电话最大长度为11个字符" , profiles = {ADD,MODIFY})
	private String linkTelephone;
	
	@MaxLength(value = 20 , message = "联系人职务最大长度为20个字符" , profiles = {ADD,MODIFY})
	private String linkPosition;
	
	@Max(value = 999999999 , message = "省份格式错误" , profiles = {ADD,MODIFY})
	private Long province;
	
	@Max(value = 999999999 , message = "城市格式错误" , profiles = {ADD,MODIFY})
	private Long city; 
	
	@Max(value = 999999999 , message = "区域格式错误" , profiles = {ADD,MODIFY})
	private Long area;
	
	@MaxLength(value = 200 , message = "供应商详细地址最大长度为200个字符" , profiles = {ADD, MODIFY})
	private String address;
	
	@MaxLength(value = 250 , message = "备注最大长度为250个字符" , profiles = {ADD, MODIFY})
	private String remark;
	
	//非表字段
	private String provinceName;
	private String cityName;
	private String areaName;
	
	
	
	
	
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
	public String getLinkName() {
		return linkName;
	}
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}
	public String getLinkTelephone() {
		return linkTelephone;
	}
	public void setLinkTelephone(String linkTelephone) {
		this.linkTelephone = linkTelephone;
	}
	public String getLinkPosition() {
		return linkPosition;
	}
	public void setLinkPosition(String linkPosition) {
		this.linkPosition = linkPosition;
	}
	public Long getProvince() {
		return province;
	}
	public void setProvince(Long province) {
		this.province = province;
	}
	public Long getCity() {
		return city;
	}
	public void setCity(Long city) {
		this.city = city;
	}
	public Long getArea() {
		return area;
	}
	public void setArea(Long area) {
		this.area = area;
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
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
}
