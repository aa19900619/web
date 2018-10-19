package com.tangj.web.controller.sys;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tangj.web.annotation.RequiresPermissions;
import com.tangj.web.controller.base.BaseController;
import com.tangj.web.pojo.sys.DictionaryInfo;
import com.tangj.web.util.ApiCommonResultVo;
import com.tangj.web.util.EnumsUtils;
import com.tangj.web.util.KeyValue;
import com.tangj.web.util.UIPage;
import com.tangj.web.vo.sys.dictionary.QueryVO;

@Controller
@RequestMapping(value = "dictionary")
public class DictionaryController extends BaseController{

	@RequiresPermissions(values = "dictionary:all")
	@RequestMapping(value = "" , method = RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView view = new ModelAndView("templates/sys/dictionary/index");
		List<KeyValue> item = EnumsUtils.getDictionaryEnum();
		view.addObject("type", item);
		return view;
	}
	
	
	@RequiresPermissions(values = "dictionary:all")
	@ResponseBody
	@RequestMapping(value = "" , method = RequestMethod.POST)
	public ApiCommonResultVo index(QueryVO vo){
		UIPage page = dictionaryService.page(vo);
		
		List<DictionaryInfo> list = page.getList().stream().map(obj -> {
			DictionaryInfo data = (DictionaryInfo) obj;
			data.setDicCode(EnumsUtils.getDictionaryEnumDesc(data.getDicCode()));
			return data;
		}).collect(Collectors.toList());
		page.setList(list);
		
		return success(page); 
	}
	
	
	@RequiresPermissions(values = "dictionary:all")
	@RequestMapping(value = "add" , method = RequestMethod.GET)
	public ModelAndView add(){
		ModelAndView view = new ModelAndView("templates/sys/dictionary/edit");
		List<KeyValue> item = EnumsUtils.getDictionaryEnum();
		view.addObject("type", item);
		return view;
	}
	
	
	@RequiresPermissions(values = "dictionary:all")
	@ResponseBody
	@RequestMapping(value = "add" , method = RequestMethod.POST)
	public ApiCommonResultVo add(DictionaryInfo info){
		//数据验证
		super.validator(info, DictionaryInfo.ADD);
		dictionaryService.add(info);
		return success("操作成功！");
	}
	
	
	@RequiresPermissions(values = "dictionary:all")
	@RequestMapping(value = "edit" , method = RequestMethod.GET)
	public ModelAndView edit(Long id){
		ModelAndView view = new ModelAndView("templates/sys/dictionary/edit");
		List<KeyValue> item = EnumsUtils.getDictionaryEnum();
		view.addObject("type", item);
		DictionaryInfo obj = dictionaryService.getDictionaryInfoBy(id);
		view.addObject("obj", obj);
		return view;
	}
	
	
	@RequiresPermissions(values = "dictionary:all")
	@ResponseBody
	@RequestMapping(value = "edit" , method = RequestMethod.POST)
	public ApiCommonResultVo edit(DictionaryInfo info){
		//数据验证
		super.validator(info, DictionaryInfo.MODIFY);
		dictionaryService.update(info);
		return success("操作成功！");
	}
}
