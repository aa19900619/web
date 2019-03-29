package com.tangj.web.service.product;

import java.util.List;

import com.tangj.web.pojo.product.ProductCategoryInfo;

public interface IProductCategoryService {

	/**
	 * 根据ID获取分类信息
	 * @param id
	 * @return
	 */
	public ProductCategoryInfo getProductCategoryInfoBy(Long id);
	
	/**
	 * 获取所有的分类信息
	 * @return
	 */
	public List<ProductCategoryInfo> getProductCategoryInfoAll();
	
	/**
	 * 添加
	 * @param obj
	 */
	public void add(ProductCategoryInfo obj);
	
	/**
	 * 修改
	 * @param obj
	 */
	public void update(ProductCategoryInfo obj);
	
}
