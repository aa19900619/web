package com.tangj.web.dao.supplier;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.tangj.web.pojo.supplier.SupplierInfo;
import com.tangj.web.util.TableConstanst;

public interface ISupplierDao {

	@Select(value = "select * from " + TableConstanst.TB_SUPPLIERS + " where id = #{id}")
	public SupplierInfo getSupplierBy(@Param("id") Long id);
	
	@SelectProvider(type = SupplierProvider.class , method = "getList")
	public List<SupplierInfo> getList(String name);
	
	@InsertProvider(type = SupplierProvider.class , method = "add")
	@Options(useGeneratedKeys = true , keyProperty = "id" , keyColumn = "id")
	public void add(SupplierInfo obj);
	
	@UpdateProvider(type = SupplierProvider.class , method = "update")
	public void update(SupplierInfo obj);
	
	
	@SelectProvider(type = SupplierProvider.class , method = "getSupList")
	public List<SupplierInfo> getSupList(Map<String, Object> param);
	
}
