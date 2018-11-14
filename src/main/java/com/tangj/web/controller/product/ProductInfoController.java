package com.tangj.web.controller.product;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tangj.web.annotation.RequiresPermissions;
import com.tangj.web.controller.base.BaseController;
import com.tangj.web.pojo.product.ProductInfo;
import com.tangj.web.service.product.IProductService;
import com.tangj.web.util.ApiCommonResultVo;
import com.tangj.web.util.UIPage;
import com.tangj.web.vo.products.product.QueryVO;

@Controller
@RequestMapping(value = "productInfo")
public class ProductInfoController extends BaseController{

	@Autowired
	private IProductService productService;
	
	@RequiresPermissions(values = "productInfo:index")
	@RequestMapping(value = "" , method = RequestMethod.GET)
	public ModelAndView index(){
		return new ModelAndView("templates/products/product/index");
	}
	@RequiresPermissions(values = "productInfo:index")
	@ResponseBody
	@RequestMapping(value = "" , method = RequestMethod.POST)
	public ApiCommonResultVo index(QueryVO vo){
		Map<String,Object> param = new HashMap<>();
		param.put("name", vo.getName());
		UIPage page = productService.page(param, vo.getPageNum(), vo.getPageSize());
		return success(page);
	}
	
	//添加
	@RequiresPermissions(values = "productInfo:add")
	@RequestMapping(value = "add" , method = RequestMethod.GET)
	public ModelAndView add(){
		ModelAndView view = new ModelAndView("templates/products/product/edit");
		initGoodsFL(view);
		initGoodsGG(view);
		return view;
	}
	@RequiresPermissions(values = "productInfo:add")
	@ResponseBody
	@RequestMapping(value = "add" , method = RequestMethod.POST)
	public ApiCommonResultVo add(ProductInfo obj){
		super.validator(obj, ProductInfo.ADD);
		initInfo(obj);
		productService.add(obj);
		return success("操作成功！");
	}
	
	
	//修改
	@RequiresPermissions(values = "productInfo:edit")
	@RequestMapping(value = "edit" , method = RequestMethod.GET)
	public ModelAndView edit(Long id){
		ModelAndView view = new ModelAndView("templates/products/product/edit");
		ProductInfo obj = productService.getProductInfoBy(id);
		view.addObject("obj", obj);
		initGoodsFL(view);
		initGoodsGG(view);
		return view;
	}
	@RequiresPermissions(values = "productInfo:edit")
	@ResponseBody
	@RequestMapping(value = "edit" , method = RequestMethod.POST)
	public ApiCommonResultVo edit(ProductInfo obj){
		super.validator(obj, ProductInfo.MODIFY);
		initInfo(obj);
		productService.update(obj);
		return success("操作成功！");
	}
	
}
