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
		/** 修改借货信息 **/
		bgoodsDao.update(obj);
		/** 修改产品库存 **/
		Map<String, Object> param = new HashMap<>();
		param.put("pCounts", obj.getNums() - obj.getNumsed());
		param.put("id", obj.getProductId());
		productDao.updateProduct(param);
	}

	@Override
	public List<BorrowGoodsInfo> getGoodsInfoList(Map<String, Object> param) {
		return null;
	}

	@Override
	public void addList(List<BorrowGoodsInfo> list) {
		Map<String, Object> param = new HashMap<>();
		for (BorrowGoodsInfo obj : list) {
			obj.setStatus(0);
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

	@Override
	public void delet(Map<String, Object> param) {
		BorrowGoodsInfo obj = bgoodsDao.getInfoById((Long) param.get("id"));
		param.put("status", "-1");
		bgoodsDao.delet(param);
		param.clear();
		/**减去商品库存**/
		param.put("pCounts", ~obj.getNums() + 1);
		param.put("id", obj.getProductId());
		productDao.updateProduct(param);
	}

	@Override
	public void systemHedging(Long id) {
		System.out.println("service经销商id：" + id);
		if(id == -1) {/**对冲所有经销商借货 未完成**/
			
		} else {/**对冲选中经销商借货 未完成**/
			
		}
	}
}
