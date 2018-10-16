package com.tangj.web.pojo.good;

import com.tangj.web.pojo.base.BaseInfo;
import com.tangj.web.util.Constanst;

import net.sf.oval.constraint.MaxLength;
import net.sf.oval.constraint.MemberOf;
import net.sf.oval.constraint.Min;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

/**
 * 商品信息类
 * @author jian.tang
 *
 */
public class GoodsInfo extends BaseInfo{

	public static final String ADD = "ADD";
	public static final String MODIFY = "MODIFY";
	
	@NotNull(message = "ID不能为空" , profiles = {MODIFY})
	@NotEmpty(message = "ID不能为空" , profiles = {MODIFY})
	@Min(value = 1 , message = "ID格式错误" , profiles = {MODIFY})
	private Long id;
	
	@NotNull(message = "商品名称不能为空" , profiles = {ADD,MODIFY})
	@NotEmpty(message = "商品名称不能为空" , profiles = {ADD,MODIFY})
	@MaxLength(value = 150 , message = "商品名称最大长度为150个字符" , profiles = {ADD,MODIFY})
	private String goodsName;
	
	@NotNull(message = "商品分类不能为空" , profiles = {ADD,MODIFY})
	@NotEmpty(message = "商品分类不能为空" , profiles = {ADD,MODIFY})
	@MaxLength(value = 20 , message = "商品分类最大长度为20个字符" , profiles = {ADD,MODIFY})
	private String goodsType;
	
	@MaxLength(value = 100 , message = "商品类别最大长度为100个字符" , profiles = {ADD,MODIFY})
	private String goodsCategory;
	
	@NotNull(message = "商品规格不能为空" , profiles = {ADD,MODIFY})
	@NotEmpty(message = "商品规格不能为空" , profiles = {ADD,MODIFY})
	@MaxLength(value = 20 , message = "商品规格最大长度为20个字符" , profiles = {ADD,MODIFY})
	private String goodsSpecifications;
	
	@MaxLength(value = 200 , message = "商品规格信息最大长度为200个字符" , profiles = {ADD,MODIFY})
	private String goodsSpecificationsDesc;
	
	@MaxLength(value = 100 , message = "条形码最大长度为100个字符" , profiles = {ADD,MODIFY})
	private String goodsBarCode;
	
	@MaxLength(value = 255 , message = "产地最大长度为255个字符" , profiles = {ADD,MODIFY})
	private String goodsPlaceOfOrigin;
	
	@NotNull(message = "状态不能为空" , profiles = {ADD,MODIFY})
	@NotEmpty(message = "状态不能为空" , profiles = {ADD,MODIFY})
	@MemberOf(value = { Constanst.STATUS_YX_STRING,Constanst.STATUS_WX_STRING } , message = "状态类型错误" , profiles = {ADD,MODIFY})
	private String goodsStatus;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public String getGoodsCategory() {
		return goodsCategory;
	}

	public void setGoodsCategory(String goodsCategory) {
		this.goodsCategory = goodsCategory;
	}

	public String getGoodsSpecifications() {
		return goodsSpecifications;
	}

	public void setGoodsSpecifications(String goodsSpecifications) {
		this.goodsSpecifications = goodsSpecifications;
	}

	public String getGoodsSpecificationsDesc() {
		return goodsSpecificationsDesc;
	}

	public void setGoodsSpecificationsDesc(String goodsSpecificationsDesc) {
		this.goodsSpecificationsDesc = goodsSpecificationsDesc;
	}

	public String getGoodsBarCode() {
		return goodsBarCode;
	}

	public void setGoodsBarCode(String goodsBarCode) {
		this.goodsBarCode = goodsBarCode;
	}

	public String getGoodsPlaceOfOrigin() {
		return goodsPlaceOfOrigin;
	}

	public void setGoodsPlaceOfOrigin(String goodsPlaceOfOrigin) {
		this.goodsPlaceOfOrigin = goodsPlaceOfOrigin;
	}

	public String getGoodsStatus() {
		return goodsStatus;
	}

	public void setGoodsStatus(String goodsStatus) {
		this.goodsStatus = goodsStatus;
	}

}
