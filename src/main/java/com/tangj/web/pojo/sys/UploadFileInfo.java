package com.tangj.web.pojo.sys;

import com.tangj.web.pojo.base.BaseInfo;

/**
 * 上传文件信息表
 * @author jian.tang
 *
 */
public class UploadFileInfo extends BaseInfo{

	private Long id;
	
	private String businessType;
	
	private String fileName;
	
	private String fileSize;
	
	private String savePath;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	
}
