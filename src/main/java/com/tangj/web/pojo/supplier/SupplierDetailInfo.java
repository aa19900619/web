package com.tangj.web.pojo.supplier;


/**
 * 供应商明细
 * @author sisimiemie
 *
 */
public class SupplierDetailInfo extends SupplierInfo{

	private Long id;
	
	private Long productId;
	
	private Long suppliersId;
	
	private Integer status;
	
	private Integer isCheck;

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

	public Long getSuppliersId() {
		return suppliersId;
	}

	public void setSuppliersId(Long suppliersId) {
		this.suppliersId = suppliersId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsCheck() {
		return isCheck;
	}

	public void setIsCheck(Integer isCheck) {
		this.isCheck = isCheck;
	}
}
