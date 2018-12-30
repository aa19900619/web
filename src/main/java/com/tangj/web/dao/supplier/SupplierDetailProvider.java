package com.tangj.web.dao.supplier;


import org.apache.ibatis.jdbc.SQL;

import com.tangj.web.util.TableConstanst;

public class SupplierDetailProvider {

	public String getListByPid() {
		SQL sql = new SQL();
		sql.SELECT(" a.* ");
		sql.SELECT(" b.name as name ");
		sql.SELECT(" b.province as province ");
		sql.SELECT(" b.city as city ");
		sql.SELECT(" b.area as area ");
		sql.FROM(TableConstanst.TB_SUPPLIERS_DETAIL + " a ");
		sql.LEFT_OUTER_JOIN(TableConstanst.TB_SUPPLIERS + " b on b.id = a.suppliers_id");
		sql.WHERE("a.product_id = #{pid}");
		return sql.toString();
	}
	
	public String add(){
		SQL sql = new SQL();
		sql.INSERT_INTO(TableConstanst.TB_SUPPLIERS_DETAIL);
		sql.INTO_COLUMNS("product_id").INTO_VALUES("#{productId}");
		sql.INTO_COLUMNS("suppliers_id").INTO_VALUES("#{suppliersId}");
		sql.INTO_COLUMNS("status").INTO_VALUES("#{status}");
		sql.INTO_COLUMNS("isCheck").INTO_VALUES("#{isCheck}");
		sql.INTO_COLUMNS("create_user_id").INTO_VALUES("#{createUserId}");
		sql.INTO_COLUMNS("create_time").INTO_VALUES("#{createTime}");
		sql.INTO_COLUMNS("update_user_id").INTO_VALUES("#{updateUserId}");
		sql.INTO_COLUMNS("update_time").INTO_VALUES("#{updateTime}");
		
		return sql.toString();
	}
	
	public String update(){
		SQL sql = new SQL();
		sql.UPDATE(TableConstanst.TB_SUPPLIERS_DETAIL);
		sql.SET("name = #{name}");
		sql.SET("link_name = #{linkName}");
		sql.SET("link_telephone = #{linkTelephone}");
		sql.SET("link_position = #{linkPosition}");
		sql.SET("province = #{province}");
		sql.SET("city = #{city}");
		sql.SET("area = #{area}");
		sql.SET("address = #{address}");
		sql.SET("remark = #{remark}");
		sql.SET("update_user_id = #{updateUserId}");
		sql.SET("update_time = #{updateTime}");
		
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	
	
}
