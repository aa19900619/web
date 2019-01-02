package com.tangj.web.service.goods.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.tangj.web.dao.goods.IGoodsDao;
import com.tangj.web.dao.product.IProductDao;
import com.tangj.web.dao.remit.IRemitDao;
import com.tangj.web.dao.supplier.ISupplierDao;
import com.tangj.web.pojo.goods.GoodsInfo;
import com.tangj.web.pojo.remit.RemitInfo;
import com.tangj.web.pojo.supplier.SupplierInfo;
import com.tangj.web.service.goods.IGoodsService;
import com.tangj.web.util.MyUtil;
import com.tangj.web.util.UIPage;

@Service
public class GoodsServiceImpl implements IGoodsService {

	@Autowired
	private IGoodsDao goodsDao;
	
	@Autowired
	private IProductDao productDao;
	
	@Autowired
	private ISupplierDao supplierDao ;
	
	@Autowired
	private IRemitDao remitDao;

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
			/**判断是否为本地经销商送货，新增状态为0，本地经销商为2**/
			SupplierInfo suppInfo = supplierDao.getSupplierBy(obj.getSuppliersId());
			if(MyUtil.isLocal(suppInfo) == 1) {
				obj.setGoodsStatus(2);
			} else {
				obj.setGoodsStatus(0);
			}
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

	@Override
	public void updateOrderStatus(GoodsInfo obj) {
		RemitInfo rInfo = new RemitInfo();
		Map<String,Object> param = new HashMap<>();
		rInfo.setCreateUserId(obj.getCreateUserId());
		rInfo.setCreateTime(obj.getCreateTime());
		if(obj.getGoodsStatus() == 2) {/**物流对数改状态**/
			param.put("id", obj.getId());
			if(obj.getPaymentStatus() == null || "".equals(obj.getPaymentStatus())) {
				param.put("logisticsStauts", "1");
			} else {/**物流结款 新增汇款信息，修改收货表汇款id**/
				rInfo.setGoodsId(obj.getId());
				rInfo.setRemitType(obj.getRemitType());
				rInfo.setRemitMoney(obj.getRemitMoney());
				rInfo.setGoodsStatus(1);
				remitDao.add(rInfo);
				param.put("remitId", rInfo.getId());
				param.put("paymentStatus", "1");
			}
			goodsDao.updateRemit(param);
				
		} else if(obj.getGoodsStatus() == 3) {/**供应商对数，默认已结款**/
			rInfo.setGoodsId(obj.getId());
			rInfo.setRemitType(obj.getRemitType());
			rInfo.setGoodsStatus(1);
			Long remitMoney = obj.getGoodsNum() / obj.getGoodsSpecifications() * obj.getGoodsBuyPrice().longValue();
			rInfo.setRemitMoney(new BigDecimal(remitMoney));
			remitDao.add(rInfo);
			
		}
		//remitService.updateRemit(obj);
		
	}

}
