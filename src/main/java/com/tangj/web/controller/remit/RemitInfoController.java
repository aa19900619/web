package com.tangj.web.controller.remit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tangj.web.annotation.RequiresPermissions;
import com.tangj.web.controller.base.BaseController;
import com.tangj.web.pojo.goods.GoodsInfo;
import com.tangj.web.pojo.remit.RemitInfo;
import com.tangj.web.service.goods.IGoodsService;
import com.tangj.web.service.remit.IRemitService;
import com.tangj.web.util.ApiCommonResultVo;
import com.tangj.web.util.UIPage;
import com.tangj.web.vo.remit.QueryVO;

@Controller
@RequestMapping(value = "remitInfo")
public class RemitInfoController extends BaseController{

	@Autowired
	private IRemitService remitService;
	private IGoodsService goodsservice;
	
	@RequiresPermissions(values = "remitInfo:index")
	@RequestMapping(value = "" , method = RequestMethod.GET)
	public ModelAndView index(){
		return new ModelAndView("templates/remit/remit/index");
	}
	@RequiresPermissions(values = "remitInfo:index")
	@ResponseBody
	@RequestMapping(value = "" , method = RequestMethod.POST)
	public ApiCommonResultVo index(QueryVO vo){
		Map<String,Object> param = new HashMap<>();
		param.put("remitId", vo.getId());
		UIPage page = remitService.page(param, vo.getPageNum(), vo.getPageSize());
		return success(page);
	}
	
	//添加
	@RequiresPermissions(values = "remitInfo:add")
	@RequestMapping(value = "add" , method = RequestMethod.GET)
	public ModelAndView add(){
		ModelAndView view = new ModelAndView("templates/remit/remit/edit");
		initGoodsFL(view);
		initGoodsGG(view);
		return view;
	}
	@RequiresPermissions(values = "remitInfo:add")
	@ResponseBody
	@RequestMapping(value = "add" , method = RequestMethod.POST)
	public ApiCommonResultVo add(RemitInfo obj){
		super.validator(obj, RemitInfo.ADD);
		initInfo(obj);
		remitService.add(obj);
		return success("操作成功！");
	}
	
	
	//修改
	@RequiresPermissions(values = "remitInfo:edit")
	@RequestMapping(value = "edit" , method = RequestMethod.GET)
	public ModelAndView edit(Long id){
		ModelAndView view = new ModelAndView("templates/remit/remit/edit");
		RemitInfo obj = remitService.getRemitInfoBy(id);
		view.addObject("obj", obj);
		Map<String,Object> param = new HashMap<>();
		param.put("id", id);
		List<GoodsInfo> list = goodsservice.getGoodsInfoList(param);
		view.addObject("lst", list);
		return view;
	}
	@RequiresPermissions(values = "remitInfo:edit")
	@ResponseBody
	@RequestMapping(value = "edit" , method = RequestMethod.POST)
	public ApiCommonResultVo edit(RemitInfo obj){
		super.validator(obj, RemitInfo.MODIFY);
		initInfo(obj);
		remitService.update(obj);
		return success("操作成功！");
	}
	
}
