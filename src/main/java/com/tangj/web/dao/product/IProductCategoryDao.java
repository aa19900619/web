package com.tangj.web.dao.product;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.tangj.web.pojo.product.ProductCategoryInfo;

public interface IProductCategoryDao {

	@SelectProvider(type = ProductCategoryProvider.class , method = "getProductCategoryInfoBy")
	public ProductCategoryInfo getProductCategoryInfoBy(Long id);
	
	/**
	 * 查询所有的商品分类信息
	 * @return
	 */
	@SelectProvider(type = ProductCategoryProvider.class , method = "getProductCategoryInfoAll")
	public List<ProductCategoryInfo> getProductCategoryInfoAll();
	
	/**
	 * 添加商品分类信息
	 * @param obj
	 */
	@InsertProvider(type = ProductCategoryProvider.class , method = "add")
	public void add(ProductCategoryInfo obj);
	
	/**
	 * 修改商品分类信息
	 * @param obj
	 */
	@UpdateProvider(type = ProductCategoryProvider.class , method = "update")
	public void update(ProductCategoryInfo obj);
	
}
