package com.tangj.web.service.remit.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.tangj.web.dao.goods.IGoodsDao;
import com.tangj.web.dao.remit.IRemitDao;
import com.tangj.web.pojo.remit.RemitInfo;
import com.tangj.web.service.remit.IRemitService;
import com.tangj.web.util.UIPage;

@Service
public class RemitInfoServiceImpl implements IRemitService{

	@Autowired
	private IRemitDao remitDao;
	
	@Autowired
	private IGoodsDao goodsDao;
	
	@Override
	public RemitInfo getRemitInfoBy(Long id) {
		return remitDao.getRemitInfoBy(id);
	}

	@Override
	public UIPage page(Map<String, Object> param, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<RemitInfo> list = remitDao.getList(param);
		return new UIPage(list);
	}

	@Override
	public void add(RemitInfo obj) {
		remitDao.add(obj);
	}

	@Override
	public void update(RemitInfo obj) {
		remitDao.update(obj);
	}

	@Override
	public void updateRemit(RemitInfo obj) {
		remitDao.update(obj);
		Map<String,Object> param = new HashMap<>();
		param.put("id", obj.getGoodsId());
		param.put("remitId", obj.getId());
		goodsDao.updateRemit(param);
	}

}
