package com.tangj.web.service.sys;

import java.util.List;

import com.tangj.web.pojo.sys.RegionInfo;

public interface IRegionService {

	/**
	 * 获取一级区域信息
	 * @return
	 */
	public List<RegionInfo> getTopRegion();
	
	/**
	 * 获取下级区域信息
	 * @param parentId
	 * @return
	 */
	public List<RegionInfo> getChildRegion(Long parentId);
	
}
