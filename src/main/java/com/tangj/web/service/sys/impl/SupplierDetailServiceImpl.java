package com.tangj.web.service.sys.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.tangj.web.dao.supplier.ISupplierDetailDao;
import com.tangj.web.pojo.supplier.SupplierDetailInfo;
import com.tangj.web.service.sys.ISupplierDetailService;
import com.tangj.web.util.UIPage;
import com.tangj.web.vo.sys.dictionary.QueryVO;

@Service
public class SupplierDetailServiceImpl implements ISupplierDetailService{

	@Autowired
	private ISupplierDetailDao supplierDetailDao;
	
	public UIPage page(QueryVO vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("code", vo.getCode());
		param.put("status", vo.getStatus());
		//List<DictionaryInfo> list = supplierDetailDao.getList(param);
		//return new UIPage(list);
		return null;
	}

	@Override
	public List<SupplierDetailInfo> getListByPid(Long pid) {
		return supplierDetailDao.getListByPid(pid);
	}

	@Override
	public void add(SupplierDetailInfo obj) {
		supplierDetailDao.add(obj);
	}

	@Override
	public void update(SupplierDetailInfo obj) {
		supplierDetailDao.update(obj);
	}
}
