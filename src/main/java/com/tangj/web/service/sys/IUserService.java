package com.tangj.web.service.sys;

import com.tangj.web.pojo.sys.UserInfo;

public interface IUserService {

	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 */
	public UserInfo login(String username,String password);
	
}
