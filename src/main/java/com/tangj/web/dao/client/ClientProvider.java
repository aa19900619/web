package com.tangj.web.dao.client;

import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import com.tangj.web.util.TableConstanst;

public class ClientProvider {

	public String getList(Map<String,Object> param){
		SQL sql = new SQL();
		sql.SELECT("*");
		sql.FROM(TableConstanst.TB_CLIENT);
		if( param.get("name") != null && !"".equals(param.get("name"))){
			sql.WHERE("name like  concat('%',#{name},'%') or name_initial like concat('%',#{name},'%') or link_name like concat('%',#{name},'%')");
		}
		return sql.toString();
	}
	
	public String add(){
		SQL sql = new SQL();
		
		sql.INSERT_INTO(TableConstanst.TB_CLIENT);
		sql.INTO_COLUMNS("name").INTO_VALUES("#{name}");
		sql.INTO_COLUMNS("name_initial").INTO_VALUES("#{nameInitial}");
		sql.INTO_COLUMNS("link_name").INTO_VALUES("#{linkName}");
		sql.INTO_COLUMNS("link_telphone").INTO_VALUES("#{linkTelphone}");
		sql.INTO_COLUMNS("link_position").INTO_VALUES("#{linkPosition}");
		sql.INTO_COLUMNS("lines").INTO_VALUES("#{lines}");
		sql.INTO_COLUMNS("goods_place_of_origin").INTO_VALUES("#{goodsPlaceOfOrigin}");
		sql.INTO_COLUMNS("address").INTO_VALUES("#{address}");
		sql.INTO_COLUMNS("remark").INTO_VALUES("#{remark}");
		sql.INTO_COLUMNS("status").INTO_VALUES("#{status}");
		sql.INTO_COLUMNS("create_user_id").INTO_VALUES("#{createUserId}");
		sql.INTO_COLUMNS("create_time").INTO_VALUES("#{createTime}");
		sql.INTO_COLUMNS("update_user_id").INTO_VALUES("#{updateUserId}");
		sql.INTO_COLUMNS("update_time").INTO_VALUES("#{updateTime}");
		
		return sql.toString();
	}
	
	
	public String update(){
		SQL sql = new SQL();
		sql.UPDATE(TableConstanst.TB_CLIENT);
		sql.SET("name = #{name}");
		sql.SET("name_initial = #{name_initial}");
		sql.SET("link_name = #{linkName}");
		sql.SET("link_telphone = #{linkTelphone}");
		sql.SET("link_position = #{linkPosition}");
		sql.SET("lines = #{lines}");
		sql.SET("address = #{address}");
		sql.SET("remark = #{remark}");
		sql.SET("update_user_id = #{updateUserId}");
		sql.SET("update_time = #{updateTime}");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	
	public String delte(Map<String,Object> param) {
		SQL sql = new SQL();
		sql.UPDATE(TableConstanst.TB_CLIENT);
		if( param.get("status") != null && !"".equals(param.get("status"))){
			sql.SET("status = #{status}");
		}
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
}
