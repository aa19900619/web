package com.tangj.web.service.borrowgoods;

import java.util.List;
import java.util.Map;

import com.tangj.web.pojo.borrowgoods.BorrowGoodsInfo;
import com.tangj.web.util.UIPage;

public interface IBorrowGoodsService {

	/**
	 * 根据ID查询收货信息
	 * 
	 * @param id
	 * @return
	 */
	public BorrowGoodsInfo getGoodsInfoBy(Long id);

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
	public List<BorrowGoodsInfo> getGoodsInfoList(Map<String, Object> param);

	/**
	 * 新增收货信息
	 * 
	 * @param obj
	 */
	public void add(BorrowGoodsInfo obj);

	/**
	 * 修改借货信息
	 * 
	 * @param obj
	 */
	public void update(BorrowGoodsInfo obj);
	
	/**
	 * 添加多个借货信息 
	 * @param list
	 */
	public void addList(List<BorrowGoodsInfo> list);
	
	/**
	 * 删除借货信息（逻辑删除）
	 * 
	 * @param param
	 */
	public void delet(Map<String, Object> param);

}
