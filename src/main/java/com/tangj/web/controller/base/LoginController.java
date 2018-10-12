package com.tangj.web.controller.base;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.tangj.web.Exception.BaseException;
import com.tangj.web.annotation.PassLogin;
import com.tangj.web.pojo.sys.UserInfo;
import com.tangj.web.service.sys.IUserService;
import com.tangj.web.util.ApiCommonResultVo;
import com.tangj.web.util.ApplicationContextHolder;
import com.tangj.web.util.Constanst;
import com.tangj.web.util.MD5Utils;
import com.tangj.web.vo.base.LoginVO;

@Controller
public class LoginController extends BaseController{

	@Autowired
	private IUserService userService;
	
	@PassLogin
	@RequestMapping(value = "login" , method = RequestMethod.GET)
	public ModelAndView login(){
		return new ModelAndView("templates/base/login");
	}
	
	@PassLogin
	@ResponseBody
	@RequestMapping(value = "login" , method = RequestMethod.POST)
	public ApiCommonResultVo login(LoginVO vo){
		super.validator(vo);
		
		HttpSession session = ApplicationContextHolder.getRequest().getSession();
		if( !vo.getCode().toUpperCase().equals(session.getAttribute("code")) ){
			throw new BaseException("验证码输入错误");
		}
		
		UserInfo user = userService.login(vo.getUsername(), MD5Utils.MD5(vo.getPassword()));
		if( user == null ){
			throw new BaseException("用户名或者密码错误");
		}
		session.setAttribute(Constanst.SESSION_KEY, user);
		return success("");
	}
	
	
	@RequestMapping(value = "logout" , method = RequestMethod.GET)
	public RedirectView logout(){
		ApplicationContextHolder.getRequest().getSession().invalidate();
		return new RedirectView("/");
	}
	
	
}
