package com.tangj.web.service.client;

import java.util.Map;

import com.tangj.web.pojo.client.ClientInfo;
import com.tangj.web.util.UIPage;

public interface IClientService {

	/**
	 * 根据ID查询商品信息
	 * @param id
	 * @return
	 */
	public ClientInfo getInfoBy(Long id);
	
	/**
	 * 分页查询客户信息
	 * @param param
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public UIPage page(Map<String,Object> param,Integer pageNum,Integer pageSize);
	
	/**
	 * 新增客户信息
	 * @param obj
	 */
	public void add(ClientInfo obj);
	
	/**
	 * 修改客户信息
	 * @param obj
	 */
	public void update(ClientInfo obj);
	
	/**
	 * 删除（逻辑删除)
	 * @param obj
	 */
	public void delte(Map<String,Object> param);
}
