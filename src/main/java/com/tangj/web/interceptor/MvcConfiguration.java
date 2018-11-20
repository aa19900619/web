package com.tangj.web.interceptor;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MvcConfiguration extends WebMvcConfigurerAdapter{

	@Value("${file.root}")
	protected String fileRoot;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("加载静态资源文件路径...........");
		super.addResourceHandlers(registry);
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
		registry.addResourceHandler("/file/**").addResourceLocations("file:" + fileRoot);
	}

	
	
}
