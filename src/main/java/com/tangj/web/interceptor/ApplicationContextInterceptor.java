package com.tangj.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.tangj.web.util.ApplicationContextHolder;
import com.tangj.web.util.HttpUtils;

public class ApplicationContextInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		HandlerMethod handle = (HandlerMethod)obj;
		ApplicationContextHolder.setRequest(request);
		ApplicationContextHolder.setResponse(response);
		ApplicationContextHolder.setHandle(handle);
		
		if( handle.getBean() instanceof BasicErrorController ){
			HttpUtils.write("请求地址不存在,或者请求参数错误");
			return false;
		}
		return super.preHandle(request, response, handle);
	}

	/**
	 * 返回model之后
	 */
	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler,ModelAndView view) throws Exception {
		if( view != null ){
			view.addObject("base", request.getContextPath());
			view.addObject("request", request);
			view.addObject("response", response);
			view.addObject("session", request.getSession());
		}
	}
	
}
