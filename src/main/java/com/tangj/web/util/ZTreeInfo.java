package com.tangj.web.util;

import java.util.ArrayList;
import java.util.List;

public class ZTreeInfo {

	public ZTreeInfo(){}
	
	private Long id;
	
	private String name;
	
	private Long pid;

	private String checked = "false";
	
	//全部展开
	private String open = "true";
	
	//下级
	private List<ZTreeInfo> children = new ArrayList<ZTreeInfo>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public List<ZTreeInfo> getChildren() {
		return children;
	}

	public void setChildren(List<ZTreeInfo> children) {
		this.children = children;
	}

	public ZTreeInfo(Long id, String name, Long pid) {
		super();
		this.id = id;
		this.name = name;
		this.pid = pid;
	}
	
}
