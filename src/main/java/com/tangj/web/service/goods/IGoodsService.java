package com.tangj.web.service.goods;

import java.util.Map;

import com.tangj.web.pojo.good.GoodsInfo;
import com.tangj.web.util.UIPage;

public interface IGoodsService {

	/**
	 * 根据ID查询商品信息
	 * @param id
	 * @return
	 */
	public GoodsInfo getGoodsInfoBy(Long id);
	
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
	public void add(GoodsInfo obj);
	
	/**
	 * 修改商品信息
	 * @param obj
	 */
	public void update(GoodsInfo obj);
	
}
