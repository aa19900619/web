package com.tangj.web.dao.sys;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.tangj.web.util.TableConstanst;

public class DictionaryProvider{

	public String getList(Map<String,Object> param){
		SQL sql = new SQL();
		sql.SELECT("*");
		sql.FROM(TableConstanst.TB_DICTIONARY);
		if( param.get("code") != null && !"".equals(param.get("code")) ){
			sql.WHERE("dic_code like concat('%',#{code},'%')");
		}
		if( param.get("status") != null && !"".equals(param.get("status")) ){
			sql.WHERE("status = #{status}");
		}
		sql.ORDER_BY(" create_time desc ");
		return sql.toString();
	}

	public String add(){
		SQL sql = new SQL();
		sql.INSERT_INTO(TableConstanst.TB_DICTIONARY);
		sql.INTO_COLUMNS("dic_code").INTO_VALUES("#{dicCode}");
		sql.INTO_COLUMNS("dic_val").INTO_VALUES("#{dicVal}");
		sql.INTO_COLUMNS("status").INTO_VALUES("#{status}");
		sql.INTO_COLUMNS("type_num").INTO_VALUES("#{typeNum}");
		sql.INTO_COLUMNS("create_user_id").INTO_VALUES("#{createUserId}");
		sql.INTO_COLUMNS("create_time").INTO_VALUES("#{createTime}");
		sql.INTO_COLUMNS("update_user_id").INTO_VALUES("#{updateUserId}");
		sql.INTO_COLUMNS("update_time").INTO_VALUES("#{updateTime}");
		return sql.toString();
	}
	
	public String update(){
		SQL sql = new SQL();
		sql.UPDATE(TableConstanst.TB_DICTIONARY);
		sql.SET("dic_code = #{dicCode}");
		sql.SET("dic_val = #{dicVal}");
		sql.SET("status = #{status}");
		sql.SET("type_num = #{typeNum}");
		sql.SET("update_user_id = #{updateUserId}");
		sql.SET("update_time = #{updateTime}");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	
}
