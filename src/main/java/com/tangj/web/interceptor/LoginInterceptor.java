package com.tangj.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.tangj.web.util.Constanst;
import com.tangj.web.util.HttpUtils;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) throws Exception {
		//判断是否是静态文件或者登陆过滤地址
		if( HttpUtils.isResourceHandler() ){
			return true;
		}
		//判断是否登陆
		Object obj = request.getSession().getAttribute(Constanst.SESSION_KEY);
		if( obj == null ){
			response.sendRedirect(request.getContextPath() + "/login");
			return false;
		}
		return super.preHandle(request, response, handle);
	}
	
}
