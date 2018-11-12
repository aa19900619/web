package com.tangj.web.vo.good.goodsInfo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.tangj.web.vo.base.BaseQueryVO;

public class QueryVO extends BaseQueryVO{

	private String name;

	private Long counts;
	
	private Date startDate;
	
	private Date endDate;
	
	private Long createId;
	
	private Long goodsId;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCounts() {
		return counts;
	}

	public void setCounts(Long counts) {
		this.counts = counts;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getCreateId() {
		return createId;
	}

	public void setCreateId(Long createId) {
		this.createId = createId;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	
	
}
