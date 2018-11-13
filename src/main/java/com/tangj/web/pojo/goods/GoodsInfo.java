package com.tangj.web.pojo.goods;

import java.math.BigDecimal;

import com.tangj.web.pojo.base.BaseInfo;

import net.sf.oval.constraint.Min;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

/**
 * 收货info
 * 
 * @author sisimiemie
 *
 */
public class GoodsInfo extends BaseInfo {
	public static final String ADD = "ADD";
	public static final String MODIFY = "MODIFY";

	@NotNull(message = "ID不能为空", profiles = { MODIFY })
	@NotEmpty(message = "ID不能为空", profiles = { MODIFY })
	@Min(value = 1, message = "ID格式错误", profiles = { MODIFY })
	private Long id;

	@NotNull(message = "产品ID不能为空", profiles = { MODIFY })
	@NotEmpty(message = "产品ID不能为空", profiles = { MODIFY })
	@Min(value = 1, message = "ID格式错误", profiles = { MODIFY })
	private Long productId;

	@NotNull(message = "收货数量不能为空", profiles = { MODIFY })
	@NotEmpty(message = "收货数量不能为空", profiles = { MODIFY })
	@Min(value = 1, message = "收货数量格式错误", profiles = { MODIFY })
	private BigDecimal goodsCounts;
	
	@NotNull(message = "收货数量不能为空", profiles = { MODIFY })
	@NotEmpty(message = "收货数量不能为空", profiles = { MODIFY })
	@Min(value = 1, message = "收货数量格式错误", profiles = { MODIFY })
	private BigDecimal goodsNum;
	private BigDecimal goodsBuyPrice;
	private BigDecimal goodsSellingPrice;
	private BigDecimal goodsFreight;
	private Integer goodsStatus;
	private Long remitId;
	private String productName;
	private Long goodsSpecifications;
	private String goodsSpecificationsDesc;
	private String dicVal;
	private String userName;
	private String goodsCategory;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public BigDecimal getGoodsCounts() {
		return goodsCounts;
	}

	public void setGoodsCounts(BigDecimal goodsCounts) {
		this.goodsCounts = goodsCounts;
	}

	public BigDecimal getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(BigDecimal goodsNum) {
		this.goodsNum = goodsNum;
	}

	public BigDecimal getGoodsBuyPrice() {
		return goodsBuyPrice;
	}

	public void setGoodsBuyPrice(BigDecimal goodsBuyPrice) {
		this.goodsBuyPrice = goodsBuyPrice;
	}

	public BigDecimal getGoodsSellingPrice() {
		return goodsSellingPrice;
	}

	public void setGoodsSellingPrice(BigDecimal goodsSellingPrice) {
		this.goodsSellingPrice = goodsSellingPrice;
	}

	public BigDecimal getGoodsFreight() {
		return goodsFreight;
	}

	public void setGoodsFreight(BigDecimal goodsFreight) {
		this.goodsFreight = goodsFreight;
	}

	public Integer getGoodsStatus() {
		return goodsStatus;
	}

	public void setGoodsStatus(Integer goodsStatus) {
		this.goodsStatus = goodsStatus;
	}

	public Long getRemitId() {
		return remitId;
	}

	public void setRemitId(Long remitId) {
		this.remitId = remitId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getGoodsSpecifications() {
		return goodsSpecifications;
	}

	public void setGoodsSpecifications(Long goodsSpecifications) {
		this.goodsSpecifications = goodsSpecifications;
	}

	public String getGoodsSpecificationsDesc() {
		return goodsSpecificationsDesc;
	}

	public void setGoodsSpecificationsDesc(String goodsSpecificationsDesc) {
		this.goodsSpecificationsDesc = goodsSpecificationsDesc;
	}

	public String getDicVal() {
		return dicVal;
	}

	public void setDicVal(String dicVal) {
		this.dicVal = dicVal;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGoodsCategory() {
		return goodsCategory;
	}

	public void setGoodsCategory(String goodsCategory) {
		this.goodsCategory = goodsCategory;
	}
	

}
