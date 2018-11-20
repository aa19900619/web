package com.tangj.web.service.sys;

import com.tangj.web.pojo.sys.UploadFileInfo;

/**
 * 上传文件服务接口
 * @author jian.tang
 *
 */
public interface IUploadFileService {

	/**
	 * 添加文件信息
	 * @param obj
	 */
	public UploadFileInfo add(UploadFileInfo obj);
	
	/**
	 * 获取文件信息
	 * @param belongId
	 * @param businessType
	 * @return
	 */
	public UploadFileInfo selectById(Long id);
	
}
