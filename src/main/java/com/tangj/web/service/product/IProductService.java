package com.tangj.web.service.product;

import java.util.List;
import java.util.Map;

import com.tangj.web.pojo.product.ProductInfo;
import com.tangj.web.util.UIPage;

public interface IProductService {

	/**
	 * 根据ID查询商品信息
	 * @param id
	 * @return
	 */
	public ProductInfo getProductInfoBy(Long id);
	
	/**
	 * 分页查询商品信息
	 * @param param
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public UIPage page(Map<String,Object> param,Integer pageNum,Integer pageSize);
	
	/**
	 * 新增商品信息
	 * @param obj
	 */
	public void add(ProductInfo obj);
	
	/**
	 * 修改商品信息
	 * @param obj
	 */
	public void update(ProductInfo obj);
	
	/**
	 * 查询商品名称
	 * @param val
	 * @return
	 */
	public List<String> getProductName(String val);
	
	/**
	 * 查询
	 * @param name
	 * @return
	 */
	public List<ProductInfo> getProductInfoBy(String name);
	
}
