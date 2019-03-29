package com.tangj.web.controller.product;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tangj.web.annotation.RequiresPermissions;
import com.tangj.web.controller.base.BaseController;
import com.tangj.web.pojo.product.ProductCategoryInfo;
import com.tangj.web.service.product.IProductCategoryService;
import com.tangj.web.util.ApiCommonResultVo;
import com.tangj.web.util.TreeUtils;
import com.tangj.web.util.ZTreeInfo;

/**
 * 商品分类控制器
 * @author jian.tang
 *
 */
@Controller
@RequestMapping(value = "productCategoryInfo")
public class ProductCategoryInfoController extends BaseController{

	@Autowired
	private IProductCategoryService productCategoryService;
	
	@RequiresPermissions(values = "productCategoryInfo:index")
	@RequestMapping(value = "" , method = RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView view = new ModelAndView("/templates/products/productCategory/index");
		return view;
	}
	
	@RequiresPermissions(values = "productCategoryInfo:index")
	@ResponseBody
	@RequestMapping(value = "" , method = RequestMethod.POST)
	public ApiCommonResultVo getTreeData(){
		List<ProductCategoryInfo> productCategoryInfoAll = productCategoryService.getProductCategoryInfoAll();
		List<ZTreeInfo> list = productCategoryInfoAll.stream().map(obj -> {
			return new ZTreeInfo(obj.getId(), obj.getName(), obj.getParentId());
		}).collect(Collectors.toList());
		return success(TreeUtils.createTree(list, Arrays.asList()));
	}
	
	@RequiresPermissions(values = "productCategoryInfo:add")
	@RequestMapping(value = "add" , method = RequestMethod.GET)
	public ModelAndView add(Long parentId){
		ModelAndView view = new ModelAndView("/templates/products/productCategory/edit");
		ProductCategoryInfo obj = new ProductCategoryInfo();
		obj.setParentId(parentId);
		view.addObject("obj", obj);
		return view;
	}
	
	
	@RequiresPermissions(values = "productCategoryInfo:add")
	@ResponseBody
	@RequestMapping(value = "add" , method = RequestMethod.POST)
	public ApiCommonResultVo add(ProductCategoryInfo obj){
		super.validator(obj, ProductCategoryInfo.ADD);
		super.initInfo(obj);
		productCategoryService.add(obj);
		return success("操作成功！");
	}
	
	
	@RequiresPermissions(values = "productCategoryInfo:update")
	@RequestMapping(value = "update" , method = RequestMethod.GET)
	public ModelAndView update(Long id){
		ModelAndView view = new ModelAndView("/templates/products/productCategory/edit");
		ProductCategoryInfo obj = productCategoryService.getProductCategoryInfoBy(id);
		view.addObject("obj", obj);
		return view;
	}
	
	@RequiresPermissions(values = "productCategoryInfo:update")
	@ResponseBody
	@RequestMapping(value = "update" , method = RequestMethod.POST)
	public ApiCommonResultVo update(ProductCategoryInfo obj){
		super.validator(obj, ProductCategoryInfo.MODIFY);
		super.initInfo(obj);
		productCategoryService.update(obj);
		return success("操作成功！");
	}
	
}
