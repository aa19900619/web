package com.tangj.web.pojo.goods;

import java.math.BigDecimal;
import java.sql.Date;

import com.tangj.web.pojo.base.BaseProInfo;

import net.sf.oval.constraint.Min;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

/**
 * 收货info
 * 
 * @author sisimiemie
 *
 */
public class GoodsInfo extends BaseProInfo {
	public static final String ADD = "ADD";
	public static final String MODIFY = "MODIFY";

	@NotNull(message = "ID不能为空", profiles = { MODIFY })
	@NotEmpty(message = "ID不能为空", profiles = { MODIFY })
	@Min(value = 1, message = "ID格式错误", profiles = { MODIFY })
	private Long id;

	private BigDecimal goodsCounts;

	@NotNull(message = "收货数量不能为空", profiles = { MODIFY, ADD })
	@NotEmpty(message = "收货数量不能为空", profiles = { MODIFY, ADD })
	@Min(value = 1, message = "收货数量不能为0", profiles = { MODIFY, ADD })
	private Long goodsNum;

	@NotNull(message = "进货价不能为空", profiles = { MODIFY, ADD })
	@NotEmpty(message = "进货价不能为空", profiles = { MODIFY, ADD })
	@Min(value = 1, message = "进货价格式错误", profiles = { MODIFY, ADD })
	private BigDecimal goodsBuyPrice;

	@NotNull(message = "出货价不能为空", profiles = { MODIFY, ADD })
	@NotEmpty(message = "出货价不能为空", profiles = { MODIFY, ADD })
	@Min(value = 1, message = "出货价格式错误", profiles = { MODIFY, ADD })
	private BigDecimal goodsSellingPrice;

	@NotNull(message = "运费不能为空", profiles = { MODIFY, ADD })
	@NotEmpty(message = "运费不能为空", profiles = { MODIFY, ADD })
	@Min(value = 1, message = "运费格式错误", profiles = { MODIFY, ADD })
	private BigDecimal goodsFreight;
	
	/**默认新增为0，删除-1*/
	private Integer goodsStatus;
	/**0新增，1物流对数，2本地送货*/
	private Integer logisticsStauts;
	/**0新增，1物流结款，2供应商结款*/
	private Integer paymentStatus;
	private Long remitId;
	private String dicVal;
	private String userName;
	private Integer remitType;
	private BigDecimal remitMoney;
	private String remitImg;
	private Date remitCreateTime;
	private Long goodsNumed;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getGoodsCounts() {
		return goodsCounts;
	}
	public void setGoodsCounts(BigDecimal goodsCounts) {
		this.goodsCounts = goodsCounts;
	}
	public Long getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(Long goodsNum) {
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
	public Integer getLogisticsStauts() {
		return logisticsStauts;
	}
	public void setLogisticsStauts(Integer logisticsStauts) {
		this.logisticsStauts = logisticsStauts;
	}
	public Integer getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(Integer paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public Long getRemitId() {
		return remitId;
	}
	public void setRemitId(Long remitId) {
		this.remitId = remitId;
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
	public Integer getRemitType() {
		return remitType;
	}
	public void setRemitType(Integer remitType) {
		this.remitType = remitType;
	}
	public BigDecimal getRemitMoney() {
		return remitMoney;
	}
	public void setRemitMoney(BigDecimal remitMoney) {
		this.remitMoney = remitMoney;
	}
	public String getRemitImg() {
		return remitImg;
	}
	public void setRemitImg(String remitImg) {
		this.remitImg = remitImg;
	}
	public Date getRemitCreateTime() {
		return remitCreateTime;
	}
	public void setRemitCreateTime(Date remitCreateTime) {
		this.remitCreateTime = remitCreateTime;
	}
	public Long getGoodsNumed() {
		return goodsNumed;
	}
	public void setGoodsNumed(Long goodsNumed) {
		this.goodsNumed = goodsNumed;
	}
}
