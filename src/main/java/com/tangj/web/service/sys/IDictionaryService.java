package com.tangj.web.service.sys;

import java.util.List;

import com.tangj.web.enums.DictionaryEnum;
import com.tangj.web.pojo.sys.DictionaryInfo;
import com.tangj.web.util.UIPage;
import com.tangj.web.vo.sys.dictionary.QueryVO;

public interface IDictionaryService {

	/**
	 * 分页查询字典信息
	 * @param vo
	 * @return
	 */
	public UIPage page(QueryVO vo);
	
	/**
	 * 根据ID获取字典信息
	 * @param id
	 * @return
	 */
	public DictionaryInfo getDictionaryInfoBy(Long id);
	
	/**
	 * 新增字典信息
	 * @param obj
	 */
	public void add(DictionaryInfo obj);
	
	/**
	 * 修改字典信息
	 * @param obj
	 */
	public void update(DictionaryInfo obj);
	
	/**
	 * 根据类型查找字典
	 * @param enums
	 * @return
	 */
	public List<DictionaryInfo> getDictionaryInfoByEnum(DictionaryEnum enums);
}
