package com.tangj.web.pojo.borrowgoods;

import java.math.BigDecimal;

import com.tangj.web.pojo.base.BaseProInfo;

import net.sf.oval.constraint.Min;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

/**
 * 借货info
 * 
 * @author sisimiemie
 *
 */
public class BorrowGoodsInfo extends BaseProInfo {
	public static final String ADD = "ADD";
	public static final String MODIFY = "MODIFY";

	@NotNull(message = "ID不能为空", profiles = { MODIFY })
	@NotEmpty(message = "ID不能为空", profiles = { MODIFY })
	@Min(value = 1, message = "ID格式错误", profiles = { MODIFY })
	private Long id;
	
	
	private Long suppliersId;
	
	@NotNull(message = "商品ID不能为空", profiles = { MODIFY, ADD  })
	@NotEmpty(message = "商品ID不能为空", profiles = { MODIFY , ADD })
	@Min(value = 1, message = "商品ID格式错误", profiles = { MODIFY, ADD  })
	private Long productId;
	private BigDecimal counts;

	@NotNull(message = "借货数量不能为空", profiles = { MODIFY, ADD })
	@NotEmpty(message = "借货数量不能为空", profiles = { MODIFY, ADD })
	@Min(value = 1, message = "借货数量不能为0", profiles = { MODIFY, ADD })
	private Long nums;
	
	private Integer type;
	private Integer status;
	private Integer moneyType;
	private BigDecimal money;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSuppliersId() {
		return suppliersId;
	}
	public void setSuppliersId(Long suppliersId) {
		this.suppliersId = suppliersId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public BigDecimal getCounts() {
		return counts;
	}
	public void setCounts(BigDecimal counts) {
		this.counts = counts;
	}
	public Long getNums() {
		return nums;
	}
	public void setNums(Long nums) {
		this.nums = nums;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getMoneyType() {
		return moneyType;
	}
	public void setMoneyType(Integer moneyType) {
		this.moneyType = moneyType;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}

}
