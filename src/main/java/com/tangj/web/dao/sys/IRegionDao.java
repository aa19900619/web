package com.tangj.web.dao.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.tangj.web.pojo.sys.RegionInfo;
import com.tangj.web.util.TableConstanst;

public interface IRegionDao {

	/**
	 * 获取区域
	 * @return
	 */
	@Select(value = "select * from " + TableConstanst.TB_REGION + " where parent_id = #{parentId}")
	public List<RegionInfo> getRegion(@Param("parentId") Long parentId);
	
}
