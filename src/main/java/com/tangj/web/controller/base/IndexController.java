package com.tangj.web.controller.base;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tangj.web.pojo.sys.RegionInfo;
import com.tangj.web.util.ApiCommonResultVo;
import com.tangj.web.util.SessionUtils;

@Controller
public class IndexController extends BaseController{

	@RequestMapping(value = "" , method = RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView view = new ModelAndView("templates/base/index");
		view.addObject("user", SessionUtils.getSessionUser());
		return view;
	}

	@RequestMapping(value = "welcome" , method = RequestMethod.GET)
	public ModelAndView welcome(){
		return new ModelAndView("templates/base/welcome");
	}
	
	@ResponseBody
	@RequestMapping(value = "region" , method = RequestMethod.GET)
	public ApiCommonResultVo region(Long parentId){
		List<RegionInfo> list = parentId == null ? Arrays.asList() : regionService.getChildRegion(parentId);
		return success(list);
	}
	
}
