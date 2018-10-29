package com.tangj.web.dao.product;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.tangj.web.pojo.good.GoodsInfo;
import com.tangj.web.util.TableConstanst;

public interface IGoodsDao {

	/**
	 * 根据ID查询商品信息
	 * @param id
	 * @return
	 */
	@Select(value = "select * from " + TableConstanst.TB_PRODUCT + " where id = #{id}")
	public GoodsInfo getGoodsInfoBy(Long id);
	
	/**
	 * 条件查询商品信息
	 * @param name
	 * @return
	 */
	@SelectProvider(type = GoodsProvider.class , method = "getList")
	public List<GoodsInfo> getList(Map<String,Object> param);
	
	/**
	 * 添加
	 * @param obj
	 */
	@InsertProvider(type = GoodsProvider.class , method = "add")
	@Options(useGeneratedKeys = true , keyProperty = "id" , keyColumn = "id")
	public void add(GoodsInfo obj);
	
	/**
	 * 修改
	 * @param obj
	 */
	@UpdateProvider(type = GoodsProvider.class , method = "update")
	public void update(GoodsInfo obj);
	
}
