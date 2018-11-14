package com.tangj.web.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;

/**
 * 
 * Servlet类
 * @author tangj
 *
 */
public class ApplicationContextHolder {

	// 请求线程
	private static ThreadLocal<HttpServletRequest> request_threadLocal = new ThreadLocal<HttpServletRequest>();

	// 响应线程
	private static ThreadLocal<HttpServletResponse> reponse_threadLocal = new ThreadLocal<HttpServletResponse>();

	//请求handle
	private static ThreadLocal<HandlerMethod> handle = new ThreadLocal<HandlerMethod>();
	
	public static void setRequest(HttpServletRequest request) {
		request_threadLocal.set(request);
	}

	public static HttpServletRequest getRequest() {
		return request_threadLocal.get();
	}

	public static void removeRequest() {
		request_threadLocal.remove();
	}

	public static void setResponse(HttpServletResponse response) {
		reponse_threadLocal.set(response);
	}

	public static HttpServletResponse getResponse() {
		return reponse_threadLocal.get();
	}

	public static void removeResponse() {
		reponse_threadLocal.remove();
	}

	public static void setHandle(HandlerMethod handlers){
		handle.set(handlers);
	}
	
	public static Object getHandle(){
		return handle.get();
	}
	
}
