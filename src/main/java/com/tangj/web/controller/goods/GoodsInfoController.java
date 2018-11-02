package com.tangj.web.controller.goods;

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
import com.tangj.web.pojo.goods.GoodsInfo;
import com.tangj.web.service.goods.IGoodsService;
import com.tangj.web.util.ApiCommonResultVo;
import com.tangj.web.util.DateUtils;
import com.tangj.web.util.UIPage;
import com.tangj.web.vo.good.goodsInfo.QueryVO;

@Controller
@RequestMapping(value = "goodsInfo")
public class GoodsInfoController extends BaseController{
	@Autowired
	private IGoodsService goodsService;
	
	@RequiresPermissions(values = "goodsInfo:index")
	@RequestMapping(value = "" , method = RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView view = new ModelAndView("templates/goods/goods/index");
		return view;
	}
	@RequiresPermissions(values = "goodsInfo:index")
	@ResponseBody
	@RequestMapping(value = "" , method = RequestMethod.POST)
	public ApiCommonResultVo index(QueryVO vo){
		Map<String,Object> param = new HashMap<>();
		param.put("name", vo.getName());
		param.put("goodsCounts", vo.getCounts());
		param.put("startDate", DateUtils.getFirstDate(vo.getStartDate()));
		param.put("endDate", DateUtils.getLastDate(vo.getEndDate()));
		UIPage page = goodsService.page(param, vo.getPageNum(), vo.getPageSize());
		return success(page);
	}
	
	//添加
	@RequiresPermissions(values = "goodsInfo:add")
	@RequestMapping(value = "add" , method = RequestMethod.GET)
	public ModelAndView add(){
		ModelAndView view = new ModelAndView("templates/goods/goods/edit");
		initGoodsFL(view);
		initGoodsGG(view);
		return view;
	}
	@RequiresPermissions(values = "goodsInfo:add")
	@ResponseBody
	@RequestMapping(value = "add" , method = RequestMethod.POST)
	public ApiCommonResultVo add(GoodsInfo obj){
		super.validator(obj, GoodsInfo.ADD);
		initInfo(obj);
		goodsService.add(obj);
		return success("操作成功！");
	}
	
	
	//修改
	@RequiresPermissions(values = "goodsInfo:edit")
	@RequestMapping(value = "edit" , method = RequestMethod.GET)
	public ModelAndView edit(Long id){
		ModelAndView view = new ModelAndView("templates/goods/goods/edit");
		GoodsInfo obj = goodsService.getGoodsInfoBy(id);
		view.addObject("obj", obj);
		initGoodsFL(view);
		initGoodsGG(view);
		return view;
	}
	@RequiresPermissions(values = "goodsInfo:edit")
	@ResponseBody
	@RequestMapping(value = "edit" , method = RequestMethod.POST)
	public ApiCommonResultVo edit(GoodsInfo obj){
		super.validator(obj, GoodsInfo.MODIFY);
		initInfo(obj);
		goodsService.update(obj);
		return success("操作成功！");
	}
}
