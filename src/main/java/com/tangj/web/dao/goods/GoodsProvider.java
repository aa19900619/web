package com.tangj.web.dao.goods;

import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import com.tangj.web.util.TableConstanst;

public class GoodsProvider {

	public String getList(Map<String,Object> param){
		SQL sql = new SQL();
		sql.SELECT("a.*");
		sql.SELECT(" b.goods_name as productName ");
		sql.SELECT(" b.goods_specifications as goodsSpecifications ");
		sql.SELECT(" b.goods_specifications_desc as goodsSpecificationsDesc ");
		sql.SELECT(" b.goods_category as goodsCategory ");
		sql.SELECT(" c.dic_val as dicVal ");
		sql.SELECT(" d.user_name as userName ");
		sql.FROM(TableConstanst.TB_GOODS + " a ");
		sql.LEFT_OUTER_JOIN(TableConstanst.TB_PRODUCT + " b on a.product_id = b.id ");
		sql.LEFT_OUTER_JOIN(TableConstanst.TB_DICTIONARY  + " c on b.goods_type = c.id ");
		sql.LEFT_OUTER_JOIN(TableConstanst.TB_USER + " d on d.id=a.create_id ");
		if( param.get("name") != null && !"".equals(param.get("name"))){
			sql.WHERE("b.goods_name like  concat('%',#{name},'%') or b.goods_name_initial like concat('%',#{name},'%')");
		}
		if( param.get("goodsCounts") != null && !"".equals(param.get("goodsCounts"))){
			sql.WHERE("a.goods_counts >= #{goodsCounts} and a.goods_counts < #{goodsCounts} + 1");
		}
		if( param.get("createId") != null && !"".equals(param.get("createId"))){
			sql.WHERE("a.create_id = #{createId}");
		}
		
		if( param.get("startDate") != null ){
			sql.WHERE("a.create_date > #{startDate}");
		}
		if( param.get("endDate") != null ){
			sql.WHERE("a.create_date <= #{endDate}");
		}
		
		
		/*if( param.get("createDateE") != null && !"".equals(param.get("createDateEx"))){
			if( param.get("createDateS") != null && !"".equals(param.get("createDate"))){
				sql.WHERE("a.create_date >= #{createDateE} and a.create_date >= #{createDateE}");
			} else {
				sql.WHERE("a.create_date >= #{createDateES} and a.create_date <= #{createDateE}");
			}
		} else{
			if( param.get("createDateS") != null && !"".equals(param.get("createDate"))){
				sql.WHERE("a.create_date >= #{createDateS} and a.create_date < #{createDateSE}");
			}
		}*/
		
		
		
		sql.ORDER_BY(" a.create_date desc ");
		return sql.toString();
	}
	
	
	
	public String getGoodsInfoById(Long id){
		SQL sql = new SQL();
		sql.SELECT("a.*");
		sql.SELECT(" b.goods_name as productName ");
		sql.SELECT(" b.goods_specifications as goodsSpecifications ");
		sql.SELECT(" b.goods_specifications_desc as goodsSpecificationsDesc ");
		sql.SELECT(" b.goods_category as goodsCategory ");
		sql.SELECT(" c.dic_val as dicVal ");
		sql.SELECT(" d.user_name as userName ");
		sql.FROM(TableConstanst.TB_GOODS + " a ");
		sql.LEFT_OUTER_JOIN(TableConstanst.TB_PRODUCT + " b on a.product_id = b.id ");
		sql.LEFT_OUTER_JOIN(TableConstanst.TB_DICTIONARY  + " c on b.goods_type = c.id ");
		sql.LEFT_OUTER_JOIN(TableConstanst.TB_USER + " d on d.id=a.create_id ");
		sql.WHERE("a.id=" + id);
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
