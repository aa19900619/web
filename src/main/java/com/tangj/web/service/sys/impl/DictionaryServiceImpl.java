package com.tangj.web.service.sys.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.tangj.web.dao.sys.IDictionaryDao;
import com.tangj.web.enums.DictionaryEnum;
import com.tangj.web.pojo.sys.DictionaryInfo;
import com.tangj.web.service.sys.IDictionaryService;
import com.tangj.web.util.UIPage;
import com.tangj.web.vo.sys.dictionary.QueryVO;

@Service
public class DictionaryServiceImpl implements IDictionaryService{

	@Autowired
	private IDictionaryDao dictionaryDao;
	
	public UIPage page(QueryVO vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("code", vo.getCode());
		param.put("status", vo.getStatus());
		List<DictionaryInfo> list = dictionaryDao.getList(param);
		return new UIPage(list);
	}

	@Override
	public DictionaryInfo getDictionaryInfoBy(Long id) {
		return dictionaryDao.getDictionaryInfoBy(id);
	}

	@Override
	public void add(DictionaryInfo obj) {
		dictionaryDao.add(obj);
	}

	@Override
	public void update(DictionaryInfo obj) {
		dictionaryDao.update(obj);
	}

	@Override
	public List<DictionaryInfo> getDictionaryInfoByEnum(DictionaryEnum enums) {
		return dictionaryDao.getDictionaryInfoByEnum(enums.toString());
	}
	
}
