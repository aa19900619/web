package com.tangj.web.service.sys;

import java.util.List;
import java.util.Map;

import com.tangj.web.pojo.supplier.SupplierInfo;
import com.tangj.web.util.UIPage;
import com.tangj.web.vo.sys.supplier.QueryVO;

public interface ISupplierService {

	/**
	 * 分页查询供应商信息
	 * @return
	 */
	public UIPage page(QueryVO vo);
	
	/**
	 * 获取供应商信息
	 * @param id
	 * @return
	 */
	public SupplierInfo getSupplierInfoBy(Long id);
	
	
	/**
	 * 新增供应商
	 * @param obj
	 */
	public void add(SupplierInfo obj);
	
	
	/**
	 * 修改供应商信息
	 * @param obj
	 */
	public void update(SupplierInfo obj);
	
	/**
	 * 查询供应商列表
	 * @param param
	 * @return
	 */
	public List<SupplierInfo> getSupList(Map<String,Object> param);
	
}
