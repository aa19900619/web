package com.tangj.web.service.sys;

import java.util.List;

import com.tangj.web.pojo.supplier.SupplierDetailInfo;
import com.tangj.web.util.UIPage;
import com.tangj.web.vo.sys.dictionary.QueryVO;

public interface ISupplierDetailService {

	/**
	 * 分页查询字典信息
	 * @param vo
	 * @return
	 */
	public UIPage page(QueryVO vo);
	
	/**
	 * 根据ID获取字典信息
	 * @param pid商品id
	 * @return
	 */
	public List<SupplierDetailInfo> getListByPid(Long pid);
	
	/**
	 * 新增
	 * @param obj
	 */
	public void add(SupplierDetailInfo obj);
	
	/**
	 * 修改
	 * @param obj
	 */
	public void update(SupplierDetailInfo obj);
	
	
}
