package com.tangj.web.service.borrowgoods.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.tangj.web.dao.borrowgoods.IBorrowGoodsDao;
import com.tangj.web.dao.product.IProductDao;
import com.tangj.web.pojo.borrowgoods.BorrowGoodsInfo;
import com.tangj.web.service.borrowgoods.IBorrowGoodsService;
import com.tangj.web.util.UIPage;

@Service
public class BorrowGoodsServiceImpl implements IBorrowGoodsService {
	@Autowired
	private IBorrowGoodsDao bgoodsDao;
	
	@Autowired
	private IProductDao productDao;

	@Override
	public BorrowGoodsInfo getGoodsInfoBy(Long id) {
		return bgoodsDao.getInfoById(id);
	}

	@Override
	public UIPage page(Map<String, Object> param, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<BorrowGoodsInfo> list = bgoodsDao.getList(param);
		return new UIPage(list);
	}

	@Override
	public void add(BorrowGoodsInfo obj) {
		bgoodsDao.add(obj);
	}

	@Override
	public void update(BorrowGoodsInfo obj) {
		bgoodsDao.update(obj);
	}

	@Override
	public List<BorrowGoodsInfo> getGoodsInfoList(Map<String, Object> param) {
		return null;
	}

	@Override
	public void addList(List<BorrowGoodsInfo> list) {
		Map<String, Object> param = new HashMap<>();
		for (BorrowGoodsInfo obj : list) {
			bgoodsDao.add(obj);
			if(obj.getType() == 0) {
				/**新增借货信息，增加商品库存**/
				param.put("pCounts", obj.getNums());
				param.put("id", obj.getProductId());
				productDao.updateProduct(param);
				param.clear();
			} else {
				/**借出商品减少库存**/
				Long nums = ~obj.getNums()+1;
				param.put("pCounts", nums);
				param.put("id", obj.getProductId());
			}
		}
	}
}
