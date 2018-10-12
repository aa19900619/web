package com.tangj.web.controller.supplier;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tangj.web.controller.base.BaseController;

@Controller
@RequestMapping(value = "supplier")
public class SupplierController extends BaseController{

	@RequestMapping(value = "" , method = RequestMethod.GET)
	public ModelAndView index(){
		return new ModelAndView("templates/sys/supplier/index");
	}
	
	
	
	
	
}
