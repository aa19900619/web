package com.tangj.web.controller.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tangj.web.pojo.product.ProductInfo;
import com.tangj.web.pojo.sys.RegionInfo;
import com.tangj.web.service.product.IProductService;
import com.tangj.web.util.ApiCommonResultVo;
import com.tangj.web.util.SessionUtils;
import com.tangj.web.vo.base.AutoCompleteVO;

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
	
	@Autowired
	private IProductService productService; 
	
	@ResponseBody
	@RequestMapping(value = "autocomplete")
	public ApiCommonResultVo getProductName(int type,String name){
		List<AutoCompleteVO> result = new ArrayList<>();
		//商品名称
		if( type == 0 ){
			result = forAutoComplete(productService.getProductName(name));
		}else if( type == 1 ){
			List<ProductInfo> list = productService.getProductInfoBy(name);
			result = list.stream().map(obj -> {
				return new AutoCompleteVO(obj.getGoodsName(),obj);
			}).collect(Collectors.toList());
		}
		return success(result);
	}
	
	
	
	
}
