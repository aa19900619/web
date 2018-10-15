package com.tangj.web.controller.supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tangj.web.annotation.RequiresPermissions;
import com.tangj.web.controller.base.BaseController;
import com.tangj.web.pojo.supplier.SupplierInfo;
import com.tangj.web.service.sys.ISupplierService;
import com.tangj.web.util.ApiCommonResultVo;
import com.tangj.web.util.UIPage;
import com.tangj.web.vo.sys.supplier.QueryVO;

@Controller
@RequestMapping(value = "supplier")
public class SupplierController extends BaseController{

	@Autowired
	private ISupplierService supplierService;
	
	@RequiresPermissions(values = "supplier:all")
	@RequestMapping(value = "" , method = RequestMethod.GET)
	public ModelAndView index(){
		return new ModelAndView("templates/sys/supplier/index");
	}
	@RequiresPermissions(values = "supplier:all")
	@ResponseBody
	@RequestMapping(value = "" , method = RequestMethod.POST)
	public ApiCommonResultVo page(QueryVO vo){
		UIPage page = supplierService.page(vo);
		return success(page);
	}
	
	@RequiresPermissions(values = "supplier:all")
	@RequestMapping(value = "add" , method = RequestMethod.GET)
	public ModelAndView add(){
		ModelAndView view = new ModelAndView("templates/sys/supplier/edit");
		initProvince(view);
		return view;
	}
	@RequiresPermissions(values = "supplier:all")
	@ResponseBody
	@RequestMapping(value = "add" , method = RequestMethod.POST)
	public ApiCommonResultVo add(SupplierInfo obj){
		super.validator(obj, SupplierInfo.ADD);
		supplierService.add(obj);
		return success("操作成功！");
	}
	
	
	@RequiresPermissions(values = "supplier:all")
	@RequestMapping(value = "edit" , method = RequestMethod.GET)
	public ModelAndView edit(Long id){
		ModelAndView view = new ModelAndView("templates/sys/supplier/edit");
		SupplierInfo obj = supplierService.getSupplierInfoBy(id);
		view.addObject("obj", obj);
		initProvince(view);
		initCity(view, obj.getProvince());
		initArea(view, obj.getCity());
		return view;
	}
	@RequiresPermissions(values = "supplier:all")
	@ResponseBody
	@RequestMapping(value = "edit" , method = RequestMethod.POST)
	public ApiCommonResultVo edit(SupplierInfo obj){
		super.validator(obj, SupplierInfo.MODIFY);
		supplierService.update(obj);
		return success("操作成功！");
	}
	
	
}
