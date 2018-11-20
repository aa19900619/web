package com.tangj.web.service.sys.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tangj.web.dao.sys.IUploadFileDao;
import com.tangj.web.pojo.sys.UploadFileInfo;
import com.tangj.web.service.sys.IUploadFileService;

@Service
public class UploadFileServiceImpl implements IUploadFileService{

	@Autowired
	private IUploadFileDao uploadFileDao;
	
	@Override
	public UploadFileInfo add(UploadFileInfo obj) {
		uploadFileDao.add(obj);
		return obj;
	}

	@Override
	public UploadFileInfo selectById(Long id) {
		return uploadFileDao.selectById(id);
	}

}
