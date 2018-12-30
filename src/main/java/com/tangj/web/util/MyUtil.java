package com.tangj.web.util;

import com.tangj.web.pojo.supplier.SupplierInfo;

public class MyUtil {

	/**
	 * 是否为本地经销商 1是
	 * @param obj
	 * @return
	 */
	public static Integer isLocal(SupplierInfo obj) {
		if(obj.getProvince() == 430000 && obj.getCity() == 430200 && obj.getArea() == 430281) {
			return 1;
		}
		return 0;
	}
}
