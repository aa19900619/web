package com.tangj.web.oval;

import com.tangj.web.config.ApplicationContextHold;
import com.tangj.web.pojo.product.ProductCategoryInfo;
import com.tangj.web.service.product.impl.ProductCategoryServiceImpl;

import net.sf.oval.constraint.CheckWithCheck.SimpleCheck;

public class ProductCategoryInfoCheckImpl implements SimpleCheck{

	private static final long serialVersionUID = 1L;

	@Override
	public boolean isSatisfied(Object validatedObject, Object value) {
		ProductCategoryInfo data = (ProductCategoryInfo)validatedObject;
		if( data.getParentId().longValue() == 0 ){
			return true;
		}
		
		ProductCategoryServiceImpl bean = ApplicationContextHold.getApplicationContext().getBean(ProductCategoryServiceImpl.class);
		ProductCategoryInfo obj = bean.getProductCategoryInfoBy((Long)value);
		if( obj == null ){
			return false;
		}
		return true;
	}

}
