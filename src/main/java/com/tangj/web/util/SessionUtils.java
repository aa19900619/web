package com.tangj.web.util;

import com.tangj.web.pojo.sys.UserInfo;

public class SessionUtils {

	public static UserInfo getSessionUser(){
		return  (UserInfo) ApplicationContextHolder.getRequest().getSession().getAttribute(Constanst.SESSION_KEY);
	}
	
}
