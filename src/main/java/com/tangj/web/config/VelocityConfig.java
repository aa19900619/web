package com.tangj.web.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

@SuppressWarnings("deprecation")
@Configuration
public class VelocityConfig {

	@Bean(name = "viewResolver")
	public VelocityViewResolver viewResolver(){
		VelocityViewResolver resolver = new VelocityViewResolver();
		resolver.setSuffix(".vm");
		resolver.setContentType("text/html;charset=utf-8");
		resolver.setDateToolAttribute("date");
		resolver.setNumberToolAttribute("number");
		resolver.setExposeSpringMacroHelpers(true);
		resolver.setExposeRequestAttributes(true);
		resolver.setRequestContextAttribute("request");
		resolver.setToolboxConfigLocation("/WEB-INF/velocity-toolbox.xml");
		return resolver;
	}
	
	@Bean(name = "velocityConfigurer")
	public VelocityConfigurer velocityConfigurer(){
		VelocityConfigurer obj = new VelocityConfigurer();
		obj.setResourceLoaderPath("classpath:");
		
		Properties velocityProperties = new Properties();
		velocityProperties.setProperty("input.encoding", "utf-8");
		velocityProperties.setProperty("output.encoding", "utf-8");
		velocityProperties.setProperty("velocimacro.library", "webapp_library.vm");
		velocityProperties.setProperty("velocimacro.library.autoreload", "true");
		obj.setVelocityProperties(velocityProperties);
		return obj;
	}
	
	
	
}
