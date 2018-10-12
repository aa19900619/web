package com.tangj.web.service.sys.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tangj.web.dao.sys.IUserDao;
import com.tangj.web.pojo.sys.UserInfo;
import com.tangj.web.service.sys.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDao userDao;
	
	public UserInfo login(String username, String password) {
		return userDao.login(username, password);
	}

}
