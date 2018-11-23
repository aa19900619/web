package com.tangj.web.dao.sys;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.tangj.web.pojo.sys.UploadFileInfo;
import com.tangj.web.util.TableConstanst;

public interface IUploadFileDao {

	/**
	 * 添加文件信息
	 * @param obj
	 */
	@InsertProvider(type = UploadFileProvider.class , method = "add")
	@Options(useGeneratedKeys = true , keyProperty = "id" , keyColumn = "id")
	public void add(UploadFileInfo obj);
	
	/**
	 * 获取文件信息
	 * @param belongId
	 * @param businessType
	 * @return
	 */
	@Select(value = "select * from " + TableConstanst.TB_UPLOAD_FILE + " where id = #{id}")
	public UploadFileInfo selectById(@Param("id") Long id);
	
}
