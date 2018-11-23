package com.tangj.web.controller.goods;

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
import com.tangj.web.pojo.goods.GoodsInfo;
import com.tangj.web.service.goods.IGoodsService;
import com.tangj.web.util.ApiCommonResultVo;
import com.tangj.web.util.UIPage;
import com.tangj.web.vo.good.goodsInfo.QueryVO;

@Controller
@RequestMapping(value = "addGoodsInfo")
public class AddGoodsInfoController extends BaseController{
	@Autowired
	private IGoodsService goodsService;
	
	@RequiresPermissions(values = "addGoodsInfo:add")
	@RequestMapping(value = "" , method = RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView view = new ModelAndView("templates/goods/goods/add");
		//initUsers(view);
		return view;
	}
	@RequiresPermissions(values = "addGoodsInfo:add")
	@ResponseBody
	@RequestMapping(value = "" , method = RequestMethod.POST)
	public ApiCommonResultVo index(QueryVO vo){
		Map<String,Object> param = new HashMap<>();
		//param.put("name", vo.getName());
		UIPage page = goodsService.page(param, vo.getPageNum(), vo.getPageSize());
		return success(page);
	}
	
	
	//添加
			@RequiresPermissions(values = "addGoodsInfo:addList")
			@RequestMapping(value = "addList" , method = RequestMethod.GET)
			public ModelAndView addList(){
				ModelAndView view = new ModelAndView("templates/goods/goods/add");
				return view;
			}
			@RequiresPermissions(values = "addGoodsInfo:addList")
			@ResponseBody
			@RequestMapping(value = "addList" , method = RequestMethod.POST)
			public ApiCommonResultVo addList(@RequestBody  List<GoodsInfo> lst){
				for (GoodsInfo obj : lst) {
					super.validator(obj, GoodsInfo.ADD);
					initInfo(obj);
					obj.setGoodsStatus(0);/*新增状态*/
				}
				goodsService.addList(lst);
				return success("操作成功！");
			}
	
}
