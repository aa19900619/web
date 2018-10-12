package com.tangj.web.controller.base;

import java.util.List;

import com.tangj.web.Exception.BaseException;
import com.tangj.web.util.ApiCommonResultVo;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

public class BaseController {

	/**
	 * 操作成功！
	 * @param obj
	 * @return
	 */
	public ApiCommonResultVo success(Object obj){
		return new ApiCommonResultVo(0, "", obj);
	}
	
	/**
	 * =================================================================
	 *功 能： 验证自定义级
	--------------------------------------------------------------------
	 *修改记录 ：
	 *日 期  版本 修改人 修改内容
	 *2017年9月19日 v1.0 jian.tang 创建
	====================================================================
	 */
	public void validator(Object obj,String...profiles){
		Validator validator = new Validator();
		List<ConstraintViolation> validate = validator.validate(obj, profiles);
		if( validate.isEmpty() ){
			return;
		}
		throw new BaseException(validate.get(0).getMessage());
	}
	
	/**
	 * 数据验证
	 * @param obj
	 * @return
	 */
	public void validator(Object obj){
		Validator validator = new Validator();
		List<ConstraintViolation> validate = validator.validate(obj);
		if( validate.isEmpty() ){
			return;
		}
		throw new BaseException(validate.get(0).getMessage());
	}
	
	
}
