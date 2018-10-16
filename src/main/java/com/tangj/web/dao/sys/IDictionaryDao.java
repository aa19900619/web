package com.tangj.web.dao.sys;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.tangj.web.pojo.sys.DictionaryInfo;
import com.tangj.web.util.TableConstanst;

public interface IDictionaryDao {

	@SelectProvider(type = DictionaryProvider.class , method = "getList")
	public List<DictionaryInfo> getList(String code);
	
	@Select(value = "select * from " + TableConstanst.TB_DICTIONARY + " where id = #{id}")
	public DictionaryInfo getDictionaryInfoBy(Long id);
	
	@InsertProvider(type = DictionaryProvider.class , method = "add")
	@Options(useGeneratedKeys = true , keyProperty = "id" , keyColumn = "id")
	public void add(DictionaryInfo info);
	
	@InsertProvider(type = DictionaryProvider.class , method = "update")
	public void update(DictionaryInfo info);
	
}
