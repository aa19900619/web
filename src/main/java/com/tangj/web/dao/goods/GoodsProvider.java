package com.tangj.web.dao.goods;

import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import com.tangj.web.util.TableConstanst;

public class GoodsProvider {

	public String getList(Map<String,Object> param){
		SQL sql = new SQL();
		sql.SELECT("a.*");
		sql.SELECT(" CONVERT(a.goods_num/b.goods_specifications,DECIMAL(10,2)) as goodsCounts ");
		sql.SELECT(" b.goods_name as productName ");
		sql.SELECT(" b.goods_specifications as goodsSpecifications ");
		sql.SELECT(" b.goods_specifications_desc as goodsSpecificationsDesc ");
		sql.SELECT(" e.name as goodsCategory ");
		sql.SELECT(" f.name as goodsCategorys ");
		sql.SELECT(" c.dic_val as dicVal ");
		sql.SELECT(" d.user_name as userName ");
		sql.FROM(TableConstanst.TB_GOODS + " a ");
		sql.LEFT_OUTER_JOIN(TableConstanst.TB_PRODUCT + " b on a.product_id = b.id ");
		sql.LEFT_OUTER_JOIN(TableConstanst.TB_DICTIONARY  + " c on b.goods_type = c.id ");
		sql.LEFT_OUTER_JOIN(TableConstanst.TB_USER + " d on d.id=a.create_user_id ");
		sql.LEFT_OUTER_JOIN(TableConstanst.TB_TYPE + " e on e.id = b.goods_category");
		sql.LEFT_OUTER_JOIN(TableConstanst.TB_TYPE + " f on f.id = b.goods_categorys");
		if( param.get("name") != null && !"".equals(param.get("name"))){
			sql.WHERE("b.goods_name = #{name}");
		}
		if( param.get("goodsCounts") != null && !"".equals(param.get("goodsCounts"))){
			sql.WHERE("a.goods_num >= #{goodsCounts} and a.goods_num < #{goodsCounts} + 1 ");
		}
		if( param.get("createId") != null && !"".equals(param.get("createId"))){
			sql.WHERE("a.create_user_id = #{createId}");
		}
		
		if( param.get("startDate") != null ){
			sql.WHERE("a.create_time > #{startDate}");
		}
		if( param.get("endDate") != null ){
			sql.WHERE("a.create_time <= #{endDate}");
		}
		if(param.get("remitId") != null && !"".equals(param.get("remitId"))) {
			sql.WHERE("a.remit_id = #{remitId}");
		}
		sql.ORDER_BY(" a.create_time desc ");
		return sql.toString();
	}
	
	
	
	public String getGoodsInfoById(Long id){
		SQL sql = new SQL();
		sql.SELECT("a.*");
		sql.SELECT(" CONVERT(a.goods_num/b.goods_specifications,DECIMAL(10,2)) as goodsCounts ");
		sql.SELECT(" b.goods_name as productName ");
		sql.SELECT(" b.goods_specifications as goodsSpecifications ");
		sql.SELECT(" b.goods_specifications_desc as goodsSpecificationsDesc ");
		sql.SELECT(" f.name as goodsCategory ");
		sql.SELECT(" g.name as goodsCategorys ");
		sql.SELECT(" c.dic_val as dicVal ");
		sql.SELECT(" d.user_name as userName ");
		sql.SELECT(" e.remit_type as remitType ");
		sql.SELECT(" e.remit_money as remitMoney ");
		sql.SELECT(" e.remit_img as remitImg ");
		sql.SELECT(" e.create_time as remitCreateTime ");
		sql.FROM(TableConstanst.TB_GOODS + " a ");
		sql.LEFT_OUTER_JOIN(TableConstanst.TB_PRODUCT + " b on a.product_id = b.id ");
		sql.LEFT_OUTER_JOIN(TableConstanst.TB_DICTIONARY  + " c on b.goods_type = c.id ");
		sql.LEFT_OUTER_JOIN(TableConstanst.TB_USER + " d on d.id=a.create_user_id ");
		sql.LEFT_OUTER_JOIN(TableConstanst.TB_REMIT + " e on a.remit_id = e.id ");
		sql.LEFT_OUTER_JOIN(TableConstanst.TB_TYPE + " f on f.id = b.goods_category");
		sql.LEFT_OUTER_JOIN(TableConstanst.TB_TYPE + " g on g.id = b.goods_categorys");
		sql.WHERE("a.id=" + id);
		return sql.toString();
	}
	
	
	public String add(){
		SQL sql = new SQL();
		sql.INSERT_INTO(TableConstanst.TB_GOODS);
		sql.INTO_COLUMNS("product_id").INTO_VALUES("#{productId}");
		sql.INTO_COLUMNS("goods_num").INTO_VALUES("#{goodsNum}");
		sql.INTO_COLUMNS("goods_buy_price").INTO_VALUES("#{goodsBuyPrice}");
		sql.INTO_COLUMNS("goods_selling_price").INTO_VALUES("#{goodsSellingPrice}");
		sql.INTO_COLUMNS("goods_freight").INTO_VALUES("#{goodsFreight}");
		sql.INTO_COLUMNS("goods_status").INTO_VALUES("#{goodsStatus}");
		sql.INTO_COLUMNS("remit_id").INTO_VALUES("#{remitId}");
		sql.INTO_COLUMNS("create_user_id").INTO_VALUES("#{createUserId}");
		sql.INTO_COLUMNS("create_time").INTO_VALUES("#{createTime}");
		sql.INTO_COLUMNS("update_user_id").INTO_VALUES("#{updateUserId}");
		sql.INTO_COLUMNS("update_time").INTO_VALUES("#{updateTime}");
		return sql.toString();
	}
	
	
	public String update(){
		SQL sql = new SQL();
		sql.UPDATE(TableConstanst.TB_GOODS);
		sql.SET("goods_num = #{goodsNum}");
		sql.SET("goods_buy_price = #{goodsBuyPrice}");
		sql.SET("goods_selling_price = #{goodsSellingPrice}");
		sql.SET("goods_freight = #{goodsFreight}");
		sql.SET("goods_status = #{goodsStatus}");
		sql.SET("remit_id = #{remitId}");
		sql.SET("update_user_id = #{updateUserId}");
		sql.SET("update_time = #{updateTime}");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	
	public String updateRemit(Map<String,Object> param) {
		SQL sql = new SQL();
		sql.UPDATE(TableConstanst.TB_GOODS);
		if( param.get("remitId") != null && !"".equals(param.get("remitId"))){
			sql.SET("remit_id = #{remitId}");
		}
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
}
