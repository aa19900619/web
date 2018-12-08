package com.tangj.web.dao.borrowgoods;

import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import com.tangj.web.util.TableConstanst;

public class BorrowGoodsProvider {

	public String getList(Map<String,Object> param){
		SQL sql = new SQL();
		sql.SELECT("a.*");
		sql.SELECT(" CONVERT(a.nums/b.goods_specifications,DECIMAL(10,2)) as counts ");
		sql.SELECT(" d.dic_val as dicVal ");
		sql.SELECT(" b.goods_name as productName ");
		sql.SELECT(" b.goods_specifications as goodsSpecifications ");
		sql.SELECT(" b.goods_specifications_desc as goodsSpecificationsDesc ");
		sql.SELECT(" b.goods_category as goodsCategory ");
		sql.SELECT(" b.goods_categorys as goodsCategorys ");
		sql.SELECT(" c.name as supName ");
		sql.SELECT(" e.user_name as userName ");
		sql.SELECT(" f.user_name as upUserName ");
		sql.FROM(TableConstanst.TB_BORROW_GOODS + " a ");
		sql.LEFT_OUTER_JOIN(TableConstanst.TB_PRODUCT + " b on b.id = a.product_id ");
		sql.LEFT_OUTER_JOIN(TableConstanst.TB_SUPPLIERS  + " c on c.id = a.suppliers_id ");
		sql.LEFT_OUTER_JOIN(TableConstanst.TB_DICTIONARY + " d on d.id = b.goods_type ");
		sql.LEFT_OUTER_JOIN(TableConstanst.TB_USER + " e on e.id = a.create_user_id ");
		sql.LEFT_OUTER_JOIN(TableConstanst.TB_USER + " f on f.id = a.update_user_id ");
		if( param.get("name") != null && !"".equals(param.get("name"))){
			sql.WHERE("b.goods_name = #{name}");
		}
		if( param.get("goodsCounts") != null && !"".equals(param.get("goodsCounts"))){
			sql.WHERE("a.goods_counts >= #{goodsCounts} and a.goods_counts < #{goodsCounts} + 1");
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
	
	
	
	public String getInfoById(Long id){
		SQL sql = new SQL();
		sql.SELECT("a.*");
		sql.SELECT(" CONVERT(a.nums/b.goods_specifications,DECIMAL(10,2)) as counts ");
		sql.SELECT(" d.dic_val as dicVal ");
		sql.SELECT(" b.goods_name as productName ");
		sql.SELECT(" b.goods_specifications as goodsSpecifications ");
		sql.SELECT(" b.goods_specifications_desc as goodsSpecificationsDesc ");
		sql.SELECT(" b.goods_category as goodsCategory ");
		sql.SELECT(" b.goods_categorys as goodsCategorys ");
		sql.SELECT(" c.name as suppliersName ");
		sql.SELECT(" e.user_name as userName ");
		sql.SELECT(" f.user_name as upUserName ");
		sql.FROM(TableConstanst.TB_BORROW_GOODS + " a ");
		sql.LEFT_OUTER_JOIN(TableConstanst.TB_PRODUCT + " b on b.id = a.product_id ");
		sql.LEFT_OUTER_JOIN(TableConstanst.TB_SUPPLIERS  + " c on c.id = a.suppliers_id ");
		sql.LEFT_OUTER_JOIN(TableConstanst.TB_DICTIONARY + " d on d.id = b.goods_type ");
		sql.LEFT_OUTER_JOIN(TableConstanst.TB_USER + " e on e.id = a.create_user_id ");
		sql.LEFT_OUTER_JOIN(TableConstanst.TB_USER + " f on f.id = a.update_user_id ");
		sql.WHERE("a.id=" + id);
		return sql.toString();
	}
	
	
	public String add(){
		SQL sql = new SQL();
		sql.INSERT_INTO(TableConstanst.TB_BORROW_GOODS);
		sql.INTO_COLUMNS("suppliers_id").INTO_VALUES("#{suppliersId}");
		sql.INTO_COLUMNS("product_id").INTO_VALUES("#{productId}");
		sql.INTO_COLUMNS("nums").INTO_VALUES("#{nums}");
		sql.INTO_COLUMNS("type").INTO_VALUES("#{type}");
		sql.INTO_COLUMNS("status").INTO_VALUES("#{status}");
		sql.INTO_COLUMNS("money_type").INTO_VALUES("#{moneyType}");
		sql.INTO_COLUMNS("money").INTO_VALUES("#{money}");
		sql.INTO_COLUMNS("create_user_id").INTO_VALUES("#{createUserId}");
		sql.INTO_COLUMNS("create_time").INTO_VALUES("#{createTime}");
		sql.INTO_COLUMNS("update_user_id").INTO_VALUES("#{updateUserId}");
		sql.INTO_COLUMNS("update_time").INTO_VALUES("#{updateTime}");
		return sql.toString();
	}
	
	
	public String update(){
		SQL sql = new SQL();
		sql.UPDATE(TableConstanst.TB_BORROW_GOODS);
		sql.SET("goods_num = #{goodsNum}");
		sql.SET("goods_buy_price = #{goodsBuyPrice}");
		sql.SET("goods_selling_price = #{goodsSellingPrice}");
		sql.SET("goods_freight = #{goodsFreight}");
		sql.SET("goods_status = #{goodsStatus}");
		sql.SET("remit_id = #{remitId}");
		sql.SET("create_user_id = #{createUserId}");
		sql.SET("create_time = #{createTime}");
		sql.SET("update_user_id = #{updateUserId}");
		sql.SET("update_time = #{updateTime}");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	
}
