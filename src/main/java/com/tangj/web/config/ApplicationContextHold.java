package com.tangj.web.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 获取spring ApplicationContext上下文
 * @author jian.tang
 *
 */
@Component
public class ApplicationContextHold implements ApplicationContextAware{

	private static ApplicationContext applicationContext = null;
	
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		applicationContext = arg0;
	}

	/**
	 * 获取bean
	 * @param name
	 * @return
	 */
	public static ApplicationContext getApplicationContext(){
		return applicationContext;
	}
	
}
