package com.tangj.web.controller.supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tangj.web.annotation.RequiresPermissions;
import com.tangj.web.controller.base.BaseController;
import com.tangj.web.service.sys.ISupplierDetailService;
import com.tangj.web.util.ApiCommonResultVo;
import com.tangj.web.vo.sys.supplier.QueryVO;

@Controller
@RequestMapping(value = "supplierDetail")
public class SupplierDetailController extends BaseController{

	@Autowired
	private ISupplierDetailService supplierDetailService;
	
	@RequiresPermissions(values = "supplier:all")
	@RequestMapping(value = "" , method = RequestMethod.GET)
	public ModelAndView index(){
		return new ModelAndView("templates/sys/supplier/index");
	}
	@RequiresPermissions(values = "supplier:all")
	@ResponseBody
	@RequestMapping(value = "" , method = RequestMethod.POST)
	public ApiCommonResultVo page(QueryVO vo){
		//UIPage page = supplierDetailService.page(vo);
		return success("");
	}
	
	
	
	
	
	
	
}
