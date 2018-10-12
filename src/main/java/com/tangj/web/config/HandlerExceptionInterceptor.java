package com.tangj.web.config;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.tangj.web.Exception.BaseException;
import com.tangj.web.Exception.UnauthorizedException;
import com.tangj.web.util.ApiCommonResultVo;

/**
 * Created by lee on 06/08/2017.
 */
@Component
public class HandlerExceptionInterceptor implements HandlerExceptionResolver {
	
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,Exception e) {
		e.printStackTrace();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
    	try {
    		
    		PrintWriter writer = response.getWriter();
    		if( e instanceof BaseException ){
    			response.setStatus(500);
    			ApiCommonResultVo vo = new ApiCommonResultVo(1,e.getMessage(),null);
	    		writer.println(JSONObject.toJSON(vo));
	    		writer.flush();
	    		writer.close();
        	}
    		else if( e instanceof NullPointerException ){
    			response.setStatus(500);
    			ApiCommonResultVo vo = new ApiCommonResultVo(1,"获取数据信息错误",null);
	    		writer.println(JSONObject.toJSON(vo));
	    		writer.flush();
	    		writer.close();
    		}
        	else if( e instanceof UnauthorizedException ){
        		response.setStatus(403);
        		ApiCommonResultVo vo = new ApiCommonResultVo(1,"无权限",null);
	    		writer.println(JSONObject.toJSON(vo));
	    		writer.flush();
	    		writer.close();
        	}
        	else{
            	response.setStatus(500);
        		ApiCommonResultVo vo = new ApiCommonResultVo(1,"系统异常",null);
	    		writer.println(JSONObject.toJSON(vo));
	    		writer.flush();
	    		writer.close();
        	}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return new ModelAndView();
	}

   
    
    
    
}
