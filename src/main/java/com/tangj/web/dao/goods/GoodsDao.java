package com.tangj.web.dao.goods;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;

import com.tangj.web.pojo.goods.GoodsInfo;

public interface GoodsDao {

	@InsertProvider(type = GoodsProvider.class , method = "add")
	@Options(useGeneratedKeys = true , keyProperty = "id" , keyColumn = "id")
	public void add(GoodsInfo obj);
	
	
}
