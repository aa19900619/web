package com.tangj.web.service.goods;

import java.util.List;
import java.util.Map;

import com.tangj.web.pojo.goods.GoodsInfo;
import com.tangj.web.util.UIPage;

public interface IGoodsService {

	/**
	 * 根据ID查询收货信息
	 * 
	 * @param id
	 * @return
	 */
	public GoodsInfo getGoodsInfoBy(Long id);

	/**
	 * 分页查询收货信息
	 * 
	 * @param param
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public UIPage page(Map<String, Object> param, Integer pageNum, Integer pageSize);
	
	/**
	 * 查询收货列表
	 * @param param
	 * @return
	 */
	public List<GoodsInfo> getGoodsInfoList(Map<String, Object> param);

	/**
	 * 新增收货信息
	 * 
	 * @param obj
	 */
	public void add(GoodsInfo obj);

	/**
	 * 修改收货信息
	 * 
	 * @param obj
	 */
	public void update(GoodsInfo obj);
	
	
	/**
	 * 新增收货信息列表
	 * @param lst
	 */
	public void addList(List<GoodsInfo> lst);
	
	/**
	 * 修改汇款id
	 * @param param
	 */
	public void updateRemit(Map<String,Object> param);

}
