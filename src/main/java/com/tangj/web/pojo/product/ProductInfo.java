package com.tangj.web.pojo.product;

import java.math.BigDecimal;
import java.util.List;

import com.tangj.web.pojo.base.BaseInfo;
import com.tangj.web.pojo.supplier.SupplierInfo;
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
public class ProductInfo extends BaseInfo{

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
	
	@NotNull(message = "商品字母名称不能为空" , profiles = {ADD,MODIFY})
	@NotEmpty(message = "商品字母名称不能为空" , profiles = {ADD,MODIFY})
	@MaxLength(value = 150 , message = "商品字母名称最大长度为150个字符" , profiles = {ADD,MODIFY})
	private String goodsNameInitial;
	
	//@NotNull(message = "商品分类不能为空" , profiles = {ADD,MODIFY})
	//@NotEmpty(message = "商品分类不能为空" , profiles = {ADD,MODIFY})
	@Min(value = 1, message = "商品分类格式错误" , profiles = {ADD,MODIFY})
	private Long goodsType;

	//@MemberOf(value = Constanst.GOODS_CATEGORY , message = "商品类别格式错误" , profiles = {ADD,MODIFY})
	@MaxLength(value = 100 , message = "商品类别最大长度为100个字符" , profiles = {ADD,MODIFY})
	private String goodsCategory;
	
	@MaxLength(value = 100 , message = "商品类别2最大长度为100个字符" , profiles = {ADD,MODIFY})
	private String goodsCategorys;
	
	//@NotNull(message = "商品规格不能为空" , profiles = {ADD,MODIFY})
	//@NotEmpty(message = "商品规格不能为空" , profiles = {ADD,MODIFY})
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
	
	private Long productCounts;
	
	private BigDecimal productDisCounts;
	
	@NotNull(message = "进货价不能为空", profiles = { MODIFY, ADD })
	@NotEmpty(message = "进货价不能为空", profiles = { MODIFY, ADD })
	@Min(value = 1, message = "进货价格式错误", profiles = { MODIFY, ADD })
	private BigDecimal productBuyPrice;
	
	@NotNull(message = "出货价不能为空", profiles = { MODIFY, ADD })
	@NotEmpty(message = "出货价不能为空", profiles = { MODIFY, ADD })
	@Min(value = 1, message = "出货价格式错误", profiles = { MODIFY, ADD })
	private BigDecimal productSellingPrice;
	
	@NotNull(message = "零售价不能为空", profiles = { MODIFY, ADD })
	@NotEmpty(message = "零售价不能为空", profiles = { MODIFY, ADD })
	@Min(value = 1, message = "零售价格式错误", profiles = { MODIFY, ADD })
	private BigDecimal productRetailPrice;
	
	@NotNull(message = "运费不能为空", profiles = { MODIFY, ADD })
	@NotEmpty(message = "运费不能为空", profiles = { MODIFY, ADD })
	@Min(value = 1, message = "运费格式错误", profiles = { MODIFY, ADD })
	private BigDecimal productFreight;
	
	private List<SupplierInfo> slist;
	private Long suppliersId;
	private String suppName;

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

	public Long getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(Long goodsType) {
		this.goodsType = goodsType;
	}

	public String getGoodsCategory() {
		return goodsCategory;
	}

	public void setGoodsCategory(String goodsCategory) {
		this.goodsCategory = goodsCategory;
	}

	public String getGoodsCategorys() {
		return goodsCategorys;
	}

	public void setGoodsCategorys(String goodsCategorys) {
		this.goodsCategorys = goodsCategorys;
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

	public Long getProductCounts() {
		return productCounts;
	}

	public void setProductCounts(Long productCounts) {
		this.productCounts = productCounts;
	}

	public BigDecimal getProductDisCounts() {
		return productDisCounts;
	}

	public void setProductDisCounts(BigDecimal productDisCounts) {
		this.productDisCounts = productDisCounts;
	}

	public BigDecimal getProductBuyPrice() {
		return productBuyPrice;
	}

	public void setProductBuyPrice(BigDecimal productBuyPrice) {
		this.productBuyPrice = productBuyPrice;
	}

	public BigDecimal getProductSellingPrice() {
		return productSellingPrice;
	}

	public void setProductSellingPrice(BigDecimal productSellingPrice) {
		this.productSellingPrice = productSellingPrice;
	}

	public BigDecimal getProductRetailPrice() {
		return productRetailPrice;
	}

	public void setProductRetailPrice(BigDecimal productRetailPrice) {
		this.productRetailPrice = productRetailPrice;
	}

	public BigDecimal getProductFreight() {
		return productFreight;
	}

	public void setProductFreight(BigDecimal productFreight) {
		this.productFreight = productFreight;
	}

	public List<SupplierInfo> getSlist() {
		return slist;
	}

	public void setSlist(List<SupplierInfo> slist) {
		this.slist = slist;
	}

	public Long getSuppliersId() {
		return suppliersId;
	}

	public void setSuppliersId(Long suppliersId) {
		this.suppliersId = suppliersId;
	}

	public String getSuppName() {
		return suppName;
	}

	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}

	public String getGoodsNameInitial() {
		return goodsNameInitial;
	}

	public void setGoodsNameInitial(String goodsNameInitial) {
		this.goodsNameInitial = goodsNameInitial;
	}
	
}
