package com.tangj.web.service.remit;

import java.util.Map;

import com.tangj.web.pojo.remit.RemitInfo;
import com.tangj.web.util.UIPage;

public interface IRemitService {

	/**
	 * 根据ID查询汇款信息
	 * @param id
	 * @return
	 */
	public RemitInfo getRemitInfoBy(Long id);
	
	/**
	 * 分页查询汇款信息
	 * @param param
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public UIPage page(Map<String,Object> param,Integer pageNum,Integer pageSize);
	
	/**
	 * 新增汇款信息
	 * @param obj
	 */
	public void add(RemitInfo obj);
	
	/**
	 * 修改
	 * @param obj
	 */
	public void update(RemitInfo obj);
	
	/**
	 * 修改汇款信息
	 * @param obj
	 */
	public void updateRemit(RemitInfo obj);
	

}
