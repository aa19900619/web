package com.tangj.web.dao.product;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.tangj.web.pojo.product.ProductInfo;
import com.tangj.web.util.TableConstanst;

public interface IProductDao {

	/**
	 * 根据ID查询商品信息
	 * @param id
	 * @return
	 */
	@Select(value = "select * from " + TableConstanst.TB_PRODUCT + " where id = #{id}")
	public ProductInfo getProductInfoBy(Long id);
	
	/**
	 * 条件查询商品信息
	 * @param name
	 * @return
	 */
	@SelectProvider(type = ProductProvider.class , method = "getList")
	public List<ProductInfo> getList(Map<String,Object> param);
	
	/**
	 * 添加
	 * @param obj
	 */
	@InsertProvider(type = ProductProvider.class , method = "add")
	@Options(useGeneratedKeys = true , keyProperty = "id" , keyColumn = "id")
	public void add(ProductInfo obj);
	
	/**
	 * 修改
	 * @param obj
	 */
	@UpdateProvider(type = ProductProvider.class , method = "update")
	public void update(ProductInfo obj);
	
	@Select(value = "select goods_name from " + TableConstanst.TB_PRODUCT + " where goods_name like concat('%',#{name},'%') limit 5")
	public List<String> getProductName(String name);
}
