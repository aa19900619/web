package com.tangj.web.service.sys.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.tangj.web.dao.supplier.ISupplierDao;
import com.tangj.web.pojo.supplier.SupplierInfo;
import com.tangj.web.service.sys.ISupplierService;
import com.tangj.web.util.UIPage;
import com.tangj.web.vo.sys.supplier.QueryVO;

@Service
public class SupplierServiceImpl implements ISupplierService{

	@Autowired
	private ISupplierDao supplierDao;
	
	@Override
	public UIPage page(QueryVO vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		List<SupplierInfo> list = supplierDao.getList(vo.getName());
		return new UIPage(list);
	}

	@Override
	public SupplierInfo getSupplierInfoBy(Long id) {
		return supplierDao.getSupplierBy(id);
	}

	@Override
	public void add(SupplierInfo obj) {
		supplierDao.add(obj);
	}

	@Override
	public void update(SupplierInfo obj) {
		supplierDao.update(obj);
	}

	@Override
	public List<SupplierInfo> getSupList(Map<String, Object> param) {
		return supplierDao.getSupList(param);
	}

}
