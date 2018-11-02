package com.tangj.web.service.sys;

import java.util.List;
import java.util.Map;

import com.tangj.web.pojo.sys.UserInfo;

public interface IUserService {

	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 */
	public UserInfo login(String username,String password);
	
	/**
	 * 初始化操作人列表
	 * @param param
	 * @return
	 */
	public List<UserInfo> queryUsers(Map<String, Object> param);
	
}
