package com.tangj.web.controller.base;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.tangj.web.Exception.BaseException;
import com.tangj.web.pojo.sys.UploadFileInfo;
import com.tangj.web.service.base.IBaseUploadService;
import com.tangj.web.service.sys.IUploadFileService;
import com.tangj.web.util.ApiCommonResultVo;
import com.tangj.web.util.DateUtils;
import com.tangj.web.util.WebUtils;

@Controller
@RequestMapping(value = "upload")
public class UploadController extends BaseController{

	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private IUploadFileService uploadFileService; 
	
	/**
	 * 文件上传
	 * 
	 * @param file
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public String uploadFile(MultipartFile file, String businessType){
		try {
			//初始化文件夹路径
			File cropFile = new File(rootpath);
			if( !cropFile.exists() ){
				cropFile.mkdirs();
			}
			
			String date = DateUtils.format(new Date(), "yyyyMMdd");
			File root = new File(rootpath + "/" + date);
			synchronized (this) {
				if( !root.exists() ){
					root.mkdirs();
				}
			}
			
			String name = file.getOriginalFilename();
			int lastIndexOf = name.lastIndexOf(".") == -1 ? 0 : name.lastIndexOf(".");
			String hzm = lastIndexOf == 0 ? "" : name.substring(lastIndexOf, name.length());
			
			//上传之前处理
			IBaseUploadService baseUploadService = null;
			boolean containsBean = applicationContext.containsBean(businessType);
			if( containsBean ){
				baseUploadService = (IBaseUploadService) applicationContext.getBean(businessType);
				String msg = baseUploadService.uploadBefore(file.getSize(), hzm);
				if( msg != null ){
					throw new BaseException(msg);
				}
			}
			
			File newFile = File.createTempFile( DateUtils.format(new Date(), "yyyyMMddHHMMssSSS") + "_",hzm ,root);
			WebUtils.copy(file.getInputStream(), new FileOutputStream(newFile));
			
			UploadFileInfo obj = new UploadFileInfo();
			initInfo(obj);
			obj.setBusinessType(businessType);
			obj.setFileName(file.getOriginalFilename());
			obj.setCreateTime(new Date());
			obj.setFileSize(WebUtils.fileSize(file.getSize()));
			obj.setSavePath(date + "/" + newFile.getName());
			UploadFileInfo result = uploadFileService.add(obj);
			
			//上传成功后处理
			if( baseUploadService != null ){
				String msg = baseUploadService.uploadSuccess(result);
				if( msg != null ){
					throw new BaseException(msg);
				}
			}
			return JSONObject.toJSONString(success(result));
		} catch (Exception e) {
			return JSONObject.toJSONString(new ApiCommonResultVo(1, e.getMessage(), null)); 
		}
	}
	
}
