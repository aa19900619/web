package com.tangj.web.dao.supplier;

import org.apache.ibatis.jdbc.SQL;

import com.tangj.web.util.TableConstanst;

public class SupplierProvider {

	public String getList(String name){
		SQL sql = new SQL();
		sql.SELECT("a.*");
		sql.SELECT(" b.region_name as provinceName ");
		sql.SELECT(" c.region_name as cityName ");
		sql.SELECT(" d.region_name as areaName ");
		sql.FROM(TableConstanst.TB_SUPPLIERS + " a ");
		sql.LEFT_OUTER_JOIN(TableConstanst.TB_REGION + " b on a.province = b.id ");
		sql.LEFT_OUTER_JOIN(TableConstanst.TB_REGION + " c on a.city = c.id ");
		sql.LEFT_OUTER_JOIN(TableConstanst.TB_REGION + " d on a.area = d.id ");
		if( name != null ){
			sql.WHERE(" a.name like concat('%',#{name},'%') ");
		}
		sql.ORDER_BY(" create_time desc ");
		return sql.toString();
	}
	
	
	public String add(){
		SQL sql = new SQL();
		sql.INSERT_INTO(TableConstanst.TB_SUPPLIERS);
		
		sql.INTO_COLUMNS("name").INTO_VALUES("#{name}");
		sql.INTO_COLUMNS("link_name").INTO_VALUES("#{linkName}");
		sql.INTO_COLUMNS("link_telephone").INTO_VALUES("#{linkTelephone}");
		sql.INTO_COLUMNS("link_position").INTO_VALUES("#{linkPosition}");
		sql.INTO_COLUMNS("province").INTO_VALUES("#{province}");
		sql.INTO_COLUMNS("city").INTO_VALUES("#{city}");
		sql.INTO_COLUMNS("area").INTO_VALUES("#{area}");
		sql.INTO_COLUMNS("address").INTO_VALUES("#{address}");
		sql.INTO_COLUMNS("remark").INTO_VALUES("#{remark}");
		sql.INTO_COLUMNS("create_user_id").INTO_VALUES("#{createUserId}");
		sql.INTO_COLUMNS("create_time").INTO_VALUES("#{createTime}");
		sql.INTO_COLUMNS("update_user_id").INTO_VALUES("#{updateUserId}");
		sql.INTO_COLUMNS("update_time").INTO_VALUES("#{updateTime}");
		
		return sql.toString();
	}
	
	public String update(){
		SQL sql = new SQL();
		sql.UPDATE(TableConstanst.TB_SUPPLIERS);
		
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
