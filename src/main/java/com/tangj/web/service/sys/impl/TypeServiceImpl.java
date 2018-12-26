package com.tangj.web.service.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tangj.web.dao.sys.ITypeDao;
import com.tangj.web.pojo.sys.TypeInfo;
import com.tangj.web.service.sys.ITypeService;

@Service
public class TypeServiceImpl implements ITypeService{

	@Autowired
	private ITypeDao typeDao;

	@Override
	public List<TypeInfo> getListByType(Integer type) {
		return typeDao.getListByType(type);
	}
	
	

}
