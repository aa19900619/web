package com.tangj.web.dao.supplier;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.tangj.web.pojo.supplier.SupplierDetailInfo;

public interface ISupplierDetailDao {

	
	@SelectProvider(type = SupplierDetailProvider.class , method = "getListByPid")
	public List<SupplierDetailInfo> getListByPid(Long pid);
	
	@InsertProvider(type = SupplierDetailProvider.class , method = "add")
	@Options(useGeneratedKeys = true , keyProperty = "id" , keyColumn = "id")
	public void add(SupplierDetailInfo obj);
	
	@UpdateProvider(type = SupplierDetailProvider.class , method = "update")
	public void update(SupplierDetailInfo obj);
	
	
	
}
