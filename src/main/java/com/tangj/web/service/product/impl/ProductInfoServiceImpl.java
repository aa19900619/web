package com.tangj.web.service.product.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.tangj.web.dao.product.IProductDao;
import com.tangj.web.pojo.product.ProductInfo;
import com.tangj.web.service.product.IProductService;
import com.tangj.web.util.UIPage;

@Service
public class ProductInfoServiceImpl implements IProductService{

	@Autowired
	private IProductDao productDao;
	
	@Override
	public ProductInfo getProductInfoBy(Long id) {
		return productDao.getProductInfoBy(id);
	}

	@Override
	public UIPage page(Map<String, Object> param, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<ProductInfo> list = productDao.getList(param);
		return new UIPage(list);
	}

	@Override
	public void add(ProductInfo obj) {
		productDao.add(obj);
	}

	@Override
	public void update(ProductInfo obj) {
		productDao.update(obj);
	}

	@Override
	public List<String> getProductName(String val) {
		return productDao.getProductName(val);
	}

	@Override
	public List<ProductInfo> getProductList(String val) {
		return productDao.getProductList(val);
	}
	
	@Override
	public List<ProductInfo> getProductInfoBy(String name) {
		return productDao.getProductInfoByName(name);
	}

}
