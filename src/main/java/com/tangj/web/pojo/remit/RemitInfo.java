package com.tangj.web.pojo.remit;

import java.math.BigDecimal;

import com.tangj.web.pojo.base.BaseInfo;

import net.sf.oval.constraint.Min;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

/**
 * 汇款info
 * @author sisimiemie
 *
 */
public class RemitInfo extends BaseInfo{
	public static final String ADD = "ADD";
	public static final String MODIFY = "MODIFY";

	@NotNull(message = "ID不能为空", profiles = { MODIFY })
	@NotEmpty(message = "ID不能为空", profiles = { MODIFY })
	@Min(value = 1, message = "ID格式错误", profiles = { MODIFY })
	private Long id;
	
	/*0现金，1微信，2银行，3其他*/
	private Integer remitType;

	@NotNull(message = "汇款金额不能为空", profiles = { MODIFY, ADD })
	@NotEmpty(message = "汇款金额不能为空", profiles = { MODIFY, ADD })
	private BigDecimal remitMoney;


	private String remitImg;
	
	/*默认0   -1删除*/
	private Integer remitStatus;
	
	private String goodsName;
	private BigDecimal goodsCounts;
	private Long goodsNum;
	private Long goodsId;
	private Integer goodsStatus;
	private BigDecimal freight;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Integer getRemitStatus() {
		return remitStatus;
	}
	public void setRemitStatus(Integer remitStatus) {
		this.remitStatus = remitStatus;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
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
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getGoodsStatus() {
		return goodsStatus;
	}
	public void setGoodsStatus(Integer goodsStatus) {
		this.goodsStatus = goodsStatus;
	}
	public BigDecimal getFreight() {
		return freight;
	}
	public void setFreight(BigDecimal freight) {
		this.freight = freight;
	}
}
