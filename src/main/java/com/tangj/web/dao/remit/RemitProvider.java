package com.tangj.web.dao.remit;

import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import com.tangj.web.util.TableConstanst;

public class RemitProvider {

	public String getList(Map<String,Object> param){
		SQL sql = new SQL();
		
		sql.SELECT("a.*");
		sql.SELECT("CONVERT(b.goods_num/c.goods_specifications,DECIMAL(10,2)) as goodsCounts");
		sql.SELECT("b.goods_num as goodsNum");
		sql.SELECT("c.goods_name as goodsName");
		sql.FROM(TableConstanst.TB_REMIT + " a");
		sql.LEFT_OUTER_JOIN(TableConstanst.TB_GOODS + " b on a.id = b.remit_id");
		sql.LEFT_OUTER_JOIN(TableConstanst.TB_PRODUCT + " c on c.id = b.product_id");
		if( param.get("id") != null && !"".equals(param.get("id"))){
			sql.WHERE("id=#{id}");
		}
		return sql.toString();
	}
	
	public String add(){
		SQL sql = new SQL();
		sql.INSERT_INTO(TableConstanst.TB_REMIT);
		sql.INTO_COLUMNS("remit_type").INTO_VALUES("#{remitType}");
		sql.INTO_COLUMNS("remit_money").INTO_VALUES("#{remitMoney}");
		sql.INTO_COLUMNS("remit_img").INTO_VALUES("#{remitImg}");
		sql.INTO_COLUMNS("remit_status").INTO_VALUES("#{remitStatus}");
		sql.INTO_COLUMNS("create_user_id").INTO_VALUES("#{createUserId}");
		sql.INTO_COLUMNS("create_time").INTO_VALUES("#{createTime}");
		sql.INTO_COLUMNS("update_user_id").INTO_VALUES("#{updateUserId}");
		sql.INTO_COLUMNS("update_time").INTO_VALUES("#{updateTime}");
		
		return sql.toString();
	}
	
	
	public String update(){
		SQL sql = new SQL();
		sql.UPDATE(TableConstanst.TB_REMIT);
		sql.SET("remit_type = #{remitType}");
		sql.SET("remit_money = #{remitMoney}");
		sql.SET("remit_img = #{remit_img}");
		sql.SET("remit_status = #{goodsSpecifications}");
		sql.SET("create_user_id = #{goodsSpecificationsDesc}");
		sql.SET("create_time = #{goodsBarCode}");
		sql.SET("update_user_id = #{goodsPlaceOfOrigin}");
		sql.SET("update_time = #{goodsStatus}");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	
	
}
