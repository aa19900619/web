package com.tangj.web.service.base;

import com.tangj.web.pojo.sys.UploadFileInfo;

public interface IBaseUploadService {

	/**
	 *=================================================================
	 *功 能： 上传之前 结果返回null表示成功
	--------------------------------------------------------------------
	 *修改记录 ：
	 *日 期  版本 修改人 修改内容
	 *2018年4月21日 v1.0 jian.tang 创建
	====================================================================
	 */
	public String uploadBefore(Long fileSize,String hzm);
	
	
	/**
	 *=================================================================
	 *功 能： 上传成功 结果返回null表示成功
	--------------------------------------------------------------------
	 *修改记录 ：
	 *日 期  版本 修改人 修改内容
	 *2018年4月21日 v1.0 jian.tang 创建
	====================================================================
	 */
	public String uploadSuccess(UploadFileInfo result);
	
}
