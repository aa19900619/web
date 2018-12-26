package com.tangj.web.dao.client;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.tangj.web.pojo.client.ClientInfo;
import com.tangj.web.util.TableConstanst;

public interface IClientDao {

	/**
	 * 根据ID查询信息
	 * @param id
	 * @return
	 */
	@Select(value = "select * from " + TableConstanst.TB_CLIENT + " where id = #{id}")
	public ClientInfo getInfoBy(Long id);
	
	/**
	 * 条件查询信息列表
	 * @param name
	 * @return
	 */
	@SelectProvider(type = ClientProvider.class , method = "getList")
	public List<ClientInfo> getList(Map<String,Object> param);
	
	/**
	 * 添加
	 * @param obj
	 */
	@InsertProvider(type = ClientProvider.class , method = "add")
	@Options(useGeneratedKeys = true , keyProperty = "id" , keyColumn = "id")
	public void add(ClientInfo obj);
	
	/**
	 * 修改
	 * @param obj
	 */
	@UpdateProvider(type = ClientProvider.class , method = "update")
	public void update(ClientInfo obj);
	
	/**
	 * 删除（逻辑删除）
	 * @param obj
	 */
	@UpdateProvider(type = ClientProvider.class , method = "delte")
	public void delte(Map<String, Object> param);
	
	
}
