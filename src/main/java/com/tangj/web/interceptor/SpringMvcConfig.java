package com.tangj.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * spring mvc公用拦截器
 * @author jian.tang
 *
 */
@Component
public class SpringMvcConfig extends WebMvcConfigurerAdapter{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
		//此顺序不能变更
		//注册HttpServletRequest和HttpServletResponse对象
		registry.addInterceptor(new ApplicationContextInterceptor());
		//登陆过滤
		registry.addInterceptor(new LoginInterceptor());
	}

}