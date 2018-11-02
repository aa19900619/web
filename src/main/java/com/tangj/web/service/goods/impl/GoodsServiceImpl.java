package com.tangj.web.service.goods.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.tangj.web.dao.goods.IGoodsDao;
import com.tangj.web.pojo.goods.GoodsInfo;
import com.tangj.web.service.goods.IGoodsService;
import com.tangj.web.util.UIPage;

@Service
public class GoodsServiceImpl implements IGoodsService {

	@Autowired
	private IGoodsDao goodsDao;

	@Override
	public GoodsInfo getGoodsInfoBy(Long id) {
		return goodsDao.getGoodsInfoBy(id);
	}

	@Override
	public UIPage page(Map<String, Object> param, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<GoodsInfo> list = goodsDao.getList(param);
		return new UIPage(list);
	}

	@Override
	public void add(GoodsInfo obj) {
		goodsDao.add(obj);
	}

	@Override
	public void update(GoodsInfo obj) {
		goodsDao.update(obj);
	}

}
