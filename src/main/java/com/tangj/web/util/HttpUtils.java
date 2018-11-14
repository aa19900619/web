package com.tangj.web.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import com.alibaba.fastjson.JSONObject;
import com.tangj.web.annotation.PassLogin;

public class HttpUtils {

	//判断是否是静态资源请求,huo
	public static boolean isResourceHandler(){
		if( ApplicationContextHolder.getHandle() instanceof ResourceHttpRequestHandler ){
			return true;
		}
		HandlerMethod handler = (HandlerMethod) ApplicationContextHolder.getHandle();
		if( handler.hasMethodAnnotation(PassLogin.class) ){
			return true;
		}
		return false;
	}
	
	public static String getRequestUrl(){
		HttpServletRequest request = ApplicationContextHolder.getRequest();
		return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
	}
	
	public static boolean isAjaxRequest(){  
	    String header = ApplicationContextHolder.getRequest().getHeader("X-Requested-With");  
	    return "XMLHttpRequest".equals(header) ? true : false;  
	}
	
	public static void write(String msg) throws Exception{
		HttpServletResponse response = ApplicationContextHolder.getResponse();
		response.setCharacterEncoding("UTF-8");
		response.setStatus(500);
		boolean bool = HttpUtils.isAjaxRequest();
		PrintWriter writer = ApplicationContextHolder.getResponse().getWriter();
		if( bool ){
			writer.write(JSONObject.toJSONString(new ApiCommonResultVo(1, msg, "")));
		}else{
			writer.write(msg);
		}
		writer.flush();
		writer.close();
	}
	
	
	/**
	 * 获取客户端请求地址
	 * @return
	 */
	public static String getRemoteAddress(){
		HttpServletRequest request = ApplicationContextHolder.getRequest();
		String ip = request.getHeader("x-forwarded-for");    
		if(ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) ip = request.getHeader("Proxy-Client-IP");    
		if(ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) ip = request.getHeader("WL-Proxy-Client-IP");    
		if(ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) ip = request.getRemoteAddr();    
		return ip;    
	}
	
}
