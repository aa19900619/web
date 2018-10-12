package com.tangj.web.dao.sys;

import org.apache.ibatis.jdbc.SQL;

import com.tangj.web.pojo.sys.DictionaryInfo;
import com.tangj.web.util.TableConstanst;

public class DictionaryProvider {

	public String getList(String code){
		SQL sql = new SQL();
		sql.SELECT("*");
		sql.FROM(TableConstanst.TB_DICTIONARY);
		if( code != null && !"".equals(code) ){
			sql.WHERE("dic_code = #{code}");
		}
		return sql.toString();
	}

	public String add(DictionaryInfo info){
		SQL sql = new SQL();
		sql.INSERT_INTO(TableConstanst.TB_DICTIONARY);
		sql.INTO_COLUMNS("dic_code").INTO_VALUES("#{dicCode}");
		sql.INTO_COLUMNS("dic_val").INTO_VALUES("#{dicVal}");
		sql.INTO_COLUMNS("status").INTO_VALUES("#{status}");
		return sql.toString();
	}
	
	public String update(DictionaryInfo info){
		SQL sql = new SQL();
		sql.UPDATE(TableConstanst.TB_DICTIONARY);
		sql.SET("dic_code = #{dicCode}");
		sql.SET("dic_val = #{dicVal}");
		sql.SET("status = #{status}");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	
}
