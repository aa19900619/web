package com.tangj.web.dao.product;

import org.apache.ibatis.jdbc.SQL;

import com.tangj.web.util.TableConstanst;

public class ProductCategoryProvider {

	public String getProductCategoryInfoBy(){
		SQL sql = new SQL();
		sql.SELECT("*");
		sql.FROM(TableConstanst.TB_PRODUCT_CATEGORY);
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	
	public String getProductCategoryInfoAll(){
		SQL sql = new SQL();
		sql.SELECT("*");
		sql.FROM(TableConstanst.TB_PRODUCT_CATEGORY);
		return sql.toString();
	}
	
	public String add(){
		SQL sql = new SQL();
		sql.INSERT_INTO(TableConstanst.TB_PRODUCT_CATEGORY);
		sql.INTO_COLUMNS("name").INTO_VALUES("#{name}");
		sql.INTO_COLUMNS("parent_id").INTO_VALUES("#{parentId}");
		sql.INTO_COLUMNS("create_user_id").INTO_VALUES("#{createUserId}");
		sql.INTO_COLUMNS("create_time").INTO_VALUES("#{createTime}");
		sql.INTO_COLUMNS("update_user_id").INTO_VALUES("#{updateUserId}");
		sql.INTO_COLUMNS("update_time").INTO_VALUES("#{updateTime}");
		return sql.toString();
	}
	
	public String update(){
		SQL sql = new SQL();
		sql.UPDATE(TableConstanst.TB_PRODUCT_CATEGORY);
		sql.SET("name = #{name}");
		sql.SET("update_user_id = #{updateUserId}");
		sql.SET("update_time = #{updateTime}");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	
}
