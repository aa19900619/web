package com.tangj.web.dao.sys;

import org.apache.ibatis.jdbc.SQL;

import com.tangj.web.util.TableConstanst;

public class UploadFileProvider {

	public String add(){
		SQL sql = new SQL();
		sql.INSERT_INTO(TableConstanst.TB_UPLOAD_FILE);
		sql.INTO_COLUMNS("business_type").INTO_VALUES("#{businessType}");
		sql.INTO_COLUMNS("file_name").INTO_VALUES("#{fileName}");
		sql.INTO_COLUMNS("file_size").INTO_VALUES("#{fileSize}");
		sql.INTO_COLUMNS("save_path").INTO_VALUES("#{savePath}");
		sql.INTO_COLUMNS("create_user_id").INTO_VALUES("#{createUserId}");
		sql.INTO_COLUMNS("create_time").INTO_VALUES("#{createTime}");
		sql.INTO_COLUMNS("update_user_id").INTO_VALUES("#{updateUserId}");
		sql.INTO_COLUMNS("update_time").INTO_VALUES("#{updateTime}");
		return sql.toString();
	}
	
}
