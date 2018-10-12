package com.tangj.web.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tangj.web.util.SessionUtils;

@Controller
public class IndexController {

	@RequestMapping(value = "" , method = RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView view = new ModelAndView("templates/base/index");
		view.addObject("user", SessionUtils.getSessionUser());
		return view;
	}

	@RequestMapping(value = "welcome" , method = RequestMethod.GET)
	public ModelAndView welcome(){
		return new ModelAndView("templates/base/welcome");
	}
	
}
