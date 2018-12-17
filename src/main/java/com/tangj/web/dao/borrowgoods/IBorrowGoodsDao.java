package com.tangj.web.dao.borrowgoods;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.tangj.web.pojo.borrowgoods.BorrowGoodsInfo;

public interface IBorrowGoodsDao {

	/**
	 * 根据ID查询借出信息
	 * 
	 * @param id
	 * @return
	 */
	@SelectProvider(type = BorrowGoodsProvider.class, method = "getInfoById")
	public BorrowGoodsInfo getInfoById(Long id);

	/**
	 * 条件查询借出信息
	 * 
	 * @param name
	 * @return
	 */
	@SelectProvider(type = BorrowGoodsProvider.class, method = "getList")
	public List<BorrowGoodsInfo> getList(Map<String, Object> param);

	/**
	 * 添加
	 * 
	 * @param obj
	 */
	@InsertProvider(type = BorrowGoodsProvider.class, method = "add")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	public void add(BorrowGoodsInfo obj);

	
	/**
	 * 修改
	 * 
	 * @param obj
	 */
	@UpdateProvider(type = BorrowGoodsProvider.class, method = "update")
	public void update(BorrowGoodsInfo obj);
	
	/**
	 * 修改
	 * 
	 * @param obj
	 */
	@UpdateProvider(type = BorrowGoodsProvider.class, method = "delet")
	public void delet(Map<String, Object> param);
	

}
