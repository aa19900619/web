package com.tangj.web.service.goods.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.tangj.web.dao.goods.IGoodsDao;
import com.tangj.web.dao.product.IProductDao;
import com.tangj.web.pojo.goods.GoodsInfo;
import com.tangj.web.service.goods.IGoodsService;
import com.tangj.web.util.UIPage;

@Service
public class GoodsServiceImpl implements IGoodsService {

	@Autowired
	private IGoodsDao goodsDao;
	
	@Autowired
	private IProductDao productDao;

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

	@Override
	public void addList(List<GoodsInfo> lst) {
		Map<String,Object> param = new HashMap<>();
		for (GoodsInfo obj : lst) {
			goodsDao.add(obj);
			/**新增收货信息，增加商品库存**/
			param.put("pCounts", obj.getGoodsNum());
			param.put("id", obj.getProductId());
			productDao.updateProduct(param);
			param.clear();
		}
	}

	@Override
	public List<GoodsInfo> getGoodsInfoList(Map<String, Object> param) {
		return goodsDao.getList(param);
	}

	@Override
	public void updateRemit(Map<String,Object> param) {
		goodsDao.updateRemit(param);
	}

	@Override
	public void updateGoodsProductInfo(GoodsInfo obj) {
		Long gnum = obj.getGoodsNum() - obj.getGoodsNumed();
		Map<String,Object> param = new HashMap<>();
		if(gnum != 0 ) {
			param.put("pCounts", gnum);
			param.put("id", obj.getProductId());
			productDao.updateProduct(param);
			param.clear();
		}
	}

}
