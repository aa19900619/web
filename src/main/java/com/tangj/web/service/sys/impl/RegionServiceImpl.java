package com.tangj.web.service.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tangj.web.dao.sys.IRegionDao;
import com.tangj.web.pojo.sys.RegionInfo;
import com.tangj.web.service.sys.IRegionService;

@Service
public class RegionServiceImpl implements IRegionService{

	@Autowired
	private IRegionDao regionDao;
	
	@Override
	public List<RegionInfo> getTopRegion() {
		return regionDao.getRegion(0L);
	}

	@Override
	public List<RegionInfo> getChildRegion(Long parentId) {
		return regionDao.getRegion(parentId);
	}

}
