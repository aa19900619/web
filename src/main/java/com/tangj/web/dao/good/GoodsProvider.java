package com.tangj.web.dao.good;

import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import com.tangj.web.util.TableConstanst;

public class GoodsProvider {

	public String getList(Map<String,Object> param){
		SQL sql = new SQL();
		sql.FROM(TableConstanst.TB_GOODS);
		if( param.get("name") != null && !"".equals(param.get("name"))){
			sql.WHERE("goods_name like  concat('%',#{name},'%')");
		}
		return sql.toString();
	}
	
	public String add(){
		SQL sql = new SQL();
		
		sql.INSERT_INTO(TableConstanst.TB_GOODS);
		sql.INTO_COLUMNS("goods_name").INTO_VALUES("#{goodsName}");
		sql.INTO_COLUMNS("goods_type").INTO_VALUES("#{goodsType}");
		sql.INTO_COLUMNS("goods_category").INTO_VALUES("#{goodsCategory}");
		sql.INTO_COLUMNS("goods_specifications").INTO_VALUES("#{goodsSpecifications}");
		sql.INTO_COLUMNS("goods_specifications_desc").INTO_VALUES("#{goodsSpecificationsDesc}");
		sql.INTO_COLUMNS("goods_bar_code").INTO_VALUES("#{goodsBarCode}");
		sql.INTO_COLUMNS("goods_place_of_origin").INTO_VALUES("#{goodsPlaceOfOrigin}");
		sql.INTO_COLUMNS("goods_status").INTO_VALUES("#{goodsStatus}");
		sql.INTO_COLUMNS("create_user_id").INTO_VALUES("#{createUserId}");
		sql.INTO_COLUMNS("create_time").INTO_VALUES("#{createTime}");
		sql.INTO_COLUMNS("").INTO_VALUES("#{updateUserId}");
		sql.INTO_COLUMNS("").INTO_VALUES("#{updateTime}");
		
		return sql.toString();
	}
	
	
	public String update(){
		SQL sql = new SQL();
		sql.UPDATE(TableConstanst.TB_GOODS);
		sql.SET("goods_name = #{goodsName}");
		sql.SET("goods_type = #{goodsType}");
		sql.SET("goods_category = #{goodsCategory}");
		sql.SET("goods_specifications = #{goodsSpecifications}");
		sql.SET("goods_specifications_desc = #{goodsSpecificationsDesc}");
		sql.SET("goods_bar_code = #{goodsBarCode}");
		sql.SET("goods_place_of_origin = #{goodsPlaceOfOrigin}");
		sql.SET("goods_status = #{goodsStatus}");
		sql.SET("update_user_id = #{updateUserId}");
		sql.SET("update_time = #{updateTime}");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	
	
}
