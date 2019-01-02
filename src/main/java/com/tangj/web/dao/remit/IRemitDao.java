package com.tangj.web.dao.remit;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.tangj.web.pojo.remit.RemitInfo;
import com.tangj.web.util.TableConstanst;

public interface IRemitDao {

	/**
	 * 根据ID查询汇款信息
	 * @param id
	 * @return
	 */
	@Select(value = "select * from " + TableConstanst.TB_REMIT + " where id = #{id}")
	public RemitInfo getRemitInfoBy(Long id);
	
	/**
	 * 条件查询汇款信息
	 * @param name
	 * @return
	 */
	@SelectProvider(type = RemitProvider.class , method = "getList")
	public List<RemitInfo> getList(Map<String,Object> param);
	
	/**
	 * 添加
	 * @param obj
	 */
	@InsertProvider(type = RemitProvider.class , method = "add")
	@Options(useGeneratedKeys = true , keyProperty = "id" , keyColumn = "id")
	public Long add(RemitInfo obj);
	
	/**
	 * 修改
	 * @param obj
	 */
	@UpdateProvider(type = RemitProvider.class , method = "update")
	public void update(RemitInfo obj);
	
}
