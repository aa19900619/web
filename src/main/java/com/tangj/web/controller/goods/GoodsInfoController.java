package com.tangj.web.controller.goods;

import java.math.BigDecimal;
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
import com.tangj.web.pojo.remit.RemitInfo;
import com.tangj.web.service.goods.IGoodsService;
import com.tangj.web.service.remit.IRemitService;
import com.tangj.web.util.ApiCommonResultVo;
import com.tangj.web.util.DateUtils;
import com.tangj.web.util.UIPage;
import com.tangj.web.vo.good.goodsInfo.QueryVO;

@Controller
@RequestMapping(value = "goodsInfo")
public class GoodsInfoController extends BaseController{
	@Autowired
	private IGoodsService goodsService;
	
	@Autowired
	private IRemitService remitService;
	
	@RequiresPermissions(values = "goodsInfo:index")
	@RequestMapping(value = "" , method = RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView view = new ModelAndView("templates/goods/goods/index");
		initUsers(view);
		return view;
	}
	@RequiresPermissions(values = "goodsInfo:index")
	@ResponseBody
	@RequestMapping(value = "" , method = RequestMethod.POST)
	public ApiCommonResultVo index(QueryVO vo){
		Map<String,Object> param = new HashMap<>();
		param.put("name", vo.getName());
		param.put("createId", vo.getCreateId());
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
		ModelAndView view = new ModelAndView("templates/goods/goods/add");
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
			return success("操作成功！");
		}
		
		
		
		//修改状态
				@RequiresPermissions(values = "goodsInfo:ediremit")
				@RequestMapping(value = "ediremit" , method = RequestMethod.GET)
				public ModelAndView ediremit(Long id,Long stype){
					ModelAndView view = new ModelAndView("templates/goods/goods/goods_remit");
					GoodsInfo obj = goodsService.getGoodsInfoBy(id);
					if(stype == 1) {//物流对数
						obj.setGoodsStatus(1);
					} else if(stype == 2) {//供应商对数
						obj.setGoodsStatus(3);
					} else if(stype == 3) {//查看
						obj.setGoodsStatus(4);
					}
					view.addObject("obj", obj);
					return view;
				}
				@RequiresPermissions(values = "goodsInfo:ediremit")
				@ResponseBody
				@RequestMapping(value = "ediremit" , method = RequestMethod.POST)
				public ApiCommonResultVo ediremit(GoodsInfo obj){
					RemitInfo rInfo = new RemitInfo();
					Map<String,Object> param = new HashMap<>();
					initInfo(rInfo);
					if(obj.getGoodsStatus() == 2) {/**物流对数改状态**/
						if(obj.getRemitMoney() == null || "".equals(obj.getRemitMoney())) {
							param.put("id", obj.getId());
							param.put("goodsStatus", "1");
							//goodsService.updateRemit(param);
						} else {/**物流结款 新增汇款信息，修改收货表汇款id**/
							rInfo.setGoodsId(obj.getId());
							rInfo.setRemitType(obj.getRemitType());
							rInfo.setRemitMoney(obj.getRemitMoney());
							rInfo.setGoodsStatus(2);
							remitService.update(rInfo);
						}
							
					} else if(obj.getGoodsStatus() == 3) {/**供应商对数，默认已结款**/
						rInfo.setGoodsId(obj.getId());
						rInfo.setRemitType(obj.getRemitType());
						rInfo.setGoodsStatus(3);
						if(obj.getRemitMoney() == null || "".equals(obj.getRemitMoney())) {
							Long remitMoney = obj.getGoodsNum() / obj.getGoodsSpecifications() * obj.getGoodsBuyPrice().longValue();
							rInfo.setRemitMoney(new BigDecimal(remitMoney));
							remitService.update(rInfo);
						}
						
					}
					
					//remitService.updateRemit(obj);
					return success("操作成功！");
				}
}
