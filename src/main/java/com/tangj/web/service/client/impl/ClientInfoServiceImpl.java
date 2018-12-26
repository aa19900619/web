package com.tangj.web.service.client.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tangj.web.dao.client.IClientDao;
import com.tangj.web.pojo.client.ClientInfo;
import com.tangj.web.service.client.IClientService;
import com.tangj.web.util.UIPage;

@Service
public class ClientInfoServiceImpl implements IClientService{

	@Autowired
	private IClientDao clientDao;

	@Override
	public ClientInfo getInfoBy(Long id) {
		return clientDao.getInfoBy(id);
	}

	@Override
	public UIPage page(Map<String, Object> param, Integer pageNum, Integer pageSize) {
		List<ClientInfo> list = clientDao.getList(param);
		return new UIPage(list);
	}

	@Override
	public void add(ClientInfo obj) {
		clientDao.add(obj);
	}

	@Override
	public void update(ClientInfo obj) {
		clientDao.update(obj);
	}

	@Override
	public void delte(Map<String, Object> param) {
		clientDao.delte(param);
	}
}
