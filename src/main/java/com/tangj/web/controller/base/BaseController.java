package com.tangj.web.controller.base;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.ModelAndView;

import com.tangj.web.Exception.BaseException;
import com.tangj.web.enums.DictionaryEnum;
import com.tangj.web.pojo.base.BaseInfo;
import com.tangj.web.pojo.sys.DictionaryInfo;
import com.tangj.web.pojo.sys.RegionInfo;
import com.tangj.web.pojo.sys.UserInfo;
import com.tangj.web.service.sys.IDictionaryService;
import com.tangj.web.service.sys.IRegionService;
import com.tangj.web.service.sys.IUserService;
import com.tangj.web.util.ApiCommonResultVo;
import com.tangj.web.util.SessionUtils;
import com.tangj.web.vo.base.AutoCompleteVO;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

public class BaseController {

	@Autowired
	protected IRegionService regionService;
	
	@Autowired
	protected IDictionaryService dictionaryService;
	
	@Autowired
	protected IUserService iUserService;
	
	@Value("${file.root}")
	protected String rootpath;
	
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
	
	
	/**
	 * 初始化省份
	 * @param view
	 */
	protected void initProvince(ModelAndView view){
		List<RegionInfo> list = regionService.getTopRegion();
		view.addObject("provinces", list);
	}
	
	/**
	 * 初始化城市
	 * @param view
	 * @param provinceId
	 */
	protected void initCity(ModelAndView view,Long provinceId){
		List<RegionInfo> list = null;
		if( provinceId == null ){
			list = Arrays.asList();
		}else{
			list = regionService.getChildRegion(provinceId);
		}
		view.addObject("citys", list);
	}
	
	/**
	 * 初始化城市
	 * @param view
	 * @param cityId
	 */
	protected void initArea(ModelAndView view,Long cityId){
		List<RegionInfo> list = null;
		if( cityId == null ){
			list = Arrays.asList();
		}else{
			list = regionService.getChildRegion(cityId);
		}
		view.addObject("areas", list);
	}
	
	
	protected void initInfo(BaseInfo obj){
		UserInfo user = this.getUserInfo();
		obj.setCreateUserId(user.getId());
		obj.setCreateTime(new Date());
		obj.setUpdateUserId(user.getId());
		obj.setUpdateTime(new Date());
	}
	
	
	protected UserInfo getUserInfo(){
		return SessionUtils.getSessionUser();
	}
	
	/**
	 * 初始化商品分类字典
	 * @param view
	 */
	protected void initGoodsFL(ModelAndView view){
		List<DictionaryInfo> list = dictionaryService.getDictionaryInfoByEnum(DictionaryEnum.GOOD_FL);
		view.addObject("goodsFL", list);
	}
	
	/**
	 * 初始化商品规格字典
	 * @param view
	 */
	protected void initGoodsGG(ModelAndView view){
		List<DictionaryInfo> list = dictionaryService.getDictionaryInfoByEnum(DictionaryEnum.GOOD_GG);
		view.addObject("goodsGG", list);
	}
	
	/**初始化操作人列表
	 * @param param
	 */
	public void initUsers(ModelAndView view){
		Map<String, Object> param = new HashMap<>();
		view.addObject("usersInfo", iUserService.queryUsers(param));
	}
	
	public List<AutoCompleteVO> forAutoComplete(List<String> list){
		return list.stream().map(obj -> {
			return new AutoCompleteVO(obj, obj);
		}).collect(Collectors.toList());
	}
	
}
