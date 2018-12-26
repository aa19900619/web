package com.tangj.web.controller.borrowgoods;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tangj.web.annotation.RequiresPermissions;
import com.tangj.web.controller.base.BaseController;
import com.tangj.web.service.borrowgoods.IBorrowGoodsService;
import com.tangj.web.util.ApiCommonResultVo;
import com.tangj.web.vo.good.borrowInfo.QueryVO;

@Controller
@RequestMapping(value = "sysHedging")
public class SysHedgingController extends BaseController{
	@Autowired
	private IBorrowGoodsService bgoodsService;
	
	@RequiresPermissions(values = "sysHedging:index")
	@RequestMapping(value = "" , method = RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView view = new ModelAndView("templates/goods/borrowgoods/syshedging");
		//供应商列表查询
		initSupplies(view,"本地供应商");
		return view;
	}

	@RequiresPermissions(values = "sysHedging:index")
	@ResponseBody
	@RequestMapping(value = "" , method = RequestMethod.POST)
	public ApiCommonResultVo index(QueryVO vo){
		
		return success("");
	}
	
	@RequiresPermissions(values = "sysHedging:hegding")
	@ResponseBody
	@RequestMapping(value = "hegding" , method = RequestMethod.POST)
	public ApiCommonResultVo hegding(Long id){
		bgoodsService.systemHedging(id);
		return success("操作成功！");
	}
	
	
	
}
