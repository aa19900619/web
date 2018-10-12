package com.tangj.web.vo.base;

import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

public class LoginVO {

	@NotNull(message = "用户名不能为空")
	@NotEmpty(message = "用户名不能为空")
	private String username;
	
	@NotNull(message = "密码不能为空")
	@NotEmpty(message = "密码不能为空")
	private String password;
	
	@NotNull(message = "验证码不能为空")
	@NotEmpty(message = "验证码不能为空")
	private String code;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
