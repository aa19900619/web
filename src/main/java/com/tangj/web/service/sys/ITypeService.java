package com.tangj.web.service.sys;

import java.util.List;
import com.tangj.web.pojo.sys.TypeInfo;

public interface ITypeService {
	
	/**
	 * 查询类型列表
	 * @param type
	 * @return
	 */
	public List<TypeInfo> getListByType(Integer type);
}
