package com.tangj.web.dao.goods;

import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import com.tangj.web.util.TableConstanst;

public class GoodsProvider {

	public String getList(Map<String,Object> param){
		SQL sql = new SQL();
		sql.SELECT("*");
		sql.FROM(TableConstanst.TB_GOODS);
		if( param.get("name") != null && !"".equals(param.get("name"))){
			sql.WHERE("goods_name like  concat('%',#{name},'%')");
		}
		return sql.toString();
	}
	
	public String add(){
		SQL sql = new SQL();
		
		sql.INSERT_INTO(TableConstanst.TB_GOODS);
		sql.INTO_COLUMNS("product_id").INTO_VALUES("#{productId}");
		sql.INTO_COLUMNS("goods_counts").INTO_VALUES("#{goodsCounts}");
		sql.INTO_COLUMNS("goods_num").INTO_VALUES("#{goodsNum}");
		sql.INTO_COLUMNS("goods_buy_price").INTO_VALUES("#{goodsBuyPrice}");
		sql.INTO_COLUMNS("goods_selling_price").INTO_VALUES("#{goodsSellingPrice}");
		sql.INTO_COLUMNS("goods_freight").INTO_VALUES("#{goodsFreight}");
		sql.INTO_COLUMNS("goods_status").INTO_VALUES("#{goodsStatus}");
		sql.INTO_COLUMNS("remit_id").INTO_VALUES("#{remitId}");
		sql.INTO_COLUMNS("create_id").INTO_VALUES("#{createUserId}");
		sql.INTO_COLUMNS("create_date").INTO_VALUES("#{createTime}");
		sql.INTO_COLUMNS("update_id").INTO_VALUES("#{updateUserId}");
		sql.INTO_COLUMNS("update_date").INTO_VALUES("#{updateTime}");
		sql.INTO_COLUMNS("delete_id").INTO_VALUES("#{deleteUserId}");
		sql.INTO_COLUMNS("delete_date").INTO_VALUES("#{deleteTime}");
		
		return sql.toString();
	}
	
	
	public String update(){
		SQL sql = new SQL();
		sql.UPDATE(TableConstanst.TB_PRODUCT);
		sql.SET("goods_counts = #{goodsCounts}");
		sql.SET("goods_num = #{goodsNum}");
		sql.SET("goods_buy_price = #{goodsBuyPrice}");
		sql.SET("goods_selling_price = #{goodsSellingPrice}");
		sql.SET("goods_freight = #{goodsFreight}");
		sql.SET("goods_status = #{goodsStatus}");
		sql.SET("goods_place_of_origin = #{goodsPlaceOfOrigin}");
		sql.SET("goods_status = #{goodsStatus}");
		sql.SET("remit_id = #{remitId}");
		sql.SET("create_id = #{createUserId}");
		sql.SET("create_date = #{createTime}");
		sql.SET("update_id = #{updateUserId}");
		sql.SET("update_date = #{updateTime}");
		sql.SET("delete_id = #{deleteUserId}");
		sql.SET("delete_date = #{deleteTime}");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	
	
}
