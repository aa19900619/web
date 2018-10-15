package com.tangj.web.util;

/**
 * 
 * 静态常量类
 * @author jian.tang
 *
 */
public class Constanst {

	//登录session key
	public static final String SESSION_KEY = "session_user_key";
	
	//状态
	public static final Integer STATUS_YX = 0;	//有效	
	public static final String STATUS_YX_STRING = "0";
	
	public static final Integer STATUS_WX = 1;	//无效
	public static final String STATUS_WX_STRING = "1";
	
	
	/**
	 * 只能输入两位小数点
	 */
	public static final String NUMBERTOW_PATTERN = "^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$";	
	
	/**
	 * 手机号码验证规则
	 */
	public static final String TELEPHONE_REG = "[1]{1}[0-9]{10}";
	
	
	
	
}
