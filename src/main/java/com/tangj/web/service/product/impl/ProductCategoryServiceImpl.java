package com.tangj.web.service.product.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tangj.web.dao.product.IProductCategoryDao;
import com.tangj.web.pojo.product.ProductCategoryInfo;
import com.tangj.web.service.product.IProductCategoryService;

@Service
@Transactional
public class ProductCategoryServiceImpl implements IProductCategoryService{

	@Autowired
	private IProductCategoryDao productCategoryDao;
	
	@Override
	public ProductCategoryInfo getProductCategoryInfoBy(Long id) {
		return productCategoryDao.getProductCategoryInfoBy(id);
	}
	
	@Override
	public List<ProductCategoryInfo> getProductCategoryInfoAll(){
		return productCategoryDao.getProductCategoryInfoAll();
	}

	@Override
	public void add(ProductCategoryInfo obj) {
		productCategoryDao.add(obj);
	}

	@Override
	public void update(ProductCategoryInfo obj) {
		productCategoryDao.update(obj);
	}

	
	
	
}
