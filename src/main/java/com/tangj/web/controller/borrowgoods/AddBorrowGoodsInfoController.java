package com.tangj.web.controller.borrowgoods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tangj.web.annotation.RequiresPermissions;
import com.tangj.web.controller.base.BaseController;
import com.tangj.web.pojo.borrowgoods.BorrowGoodsInfo;
import com.tangj.web.service.borrowgoods.IBorrowGoodsService;
import com.tangj.web.util.ApiCommonResultVo;
import com.tangj.web.util.UIPage;
import com.tangj.web.vo.good.borrowInfo.QueryVO;

@Controller
@RequestMapping(value = "addBorrowGoodsInfo")
public class AddBorrowGoodsInfoController extends BaseController{
	@Autowired
	private IBorrowGoodsService bgoodsService;
	
	@RequiresPermissions(values = "addBorrowGoodsInfo:add")
	@RequestMapping(value = "" , method = RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView view = new ModelAndView("templates/goods/borrowgoods/add");
		//供应商列表查询未做
		initSupplies(view,"本地供应商");
		//本商行
		view.addObject("hnpfb", "一一批发");
		return view;
	}
	
	@RequiresPermissions(values = "addBorrowGoodsInfo:add")
		@ResponseBody
		@RequestMapping(value = "" , method = RequestMethod.POST)
		public ApiCommonResultVo index(QueryVO vo){
			Map<String,Object> param = new HashMap<>();
			//param.put("name", vo.getName());
			UIPage page = bgoodsService.page(param, vo.getPageNum(), vo.getPageSize());
			return success(page);
		}

	//添加
	@RequiresPermissions(values = "addBorrowGoodsInfo:addList")
	@RequestMapping(value = "addList" , method = RequestMethod.GET)
	public ModelAndView addList(){
		ModelAndView view = new ModelAndView("templates/goods/borrowgoods/add");
		return view;
	}
	@RequiresPermissions(values = "addBorrowGoodsInfo:addList")
	@ResponseBody
	@RequestMapping(value = "addList" , method = RequestMethod.POST)
	public ApiCommonResultVo addList(@RequestBody  List<BorrowGoodsInfo> lst){
		for (BorrowGoodsInfo obj : lst) {
			super.validator(obj, BorrowGoodsInfo.ADD);
			initInfo(obj);
		}
		bgoodsService.addList(lst);
		return success("操作成功！");
	}
	
}
